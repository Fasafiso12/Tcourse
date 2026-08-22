package com.example.repository

import com.example.data.catalog.CourseCatalog
import com.example.data.db.*
import com.example.model.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import java.text.SimpleDateFormat
import java.util.*

class AppRepository(private val database: AppDatabase) {

    private val progressDao = database.progressDao()
    private val statsDao = database.userStatsDao()
    private val notesDao = database.userNotesDao()
    private val favoritesDao = database.favoritesDao()
    private val mistakeDao = database.mistakeDao()
    private val achievementDao = database.achievementDao()

    // ----------------------------------------------------
    // User Stats & Profile
    // ----------------------------------------------------
    val userStatsFlow: Flow<UserStatsEntity> = statsDao.getUserStatsFlow().map { entity ->
        entity ?: UserStatsEntity(
            id = 1,
            username = "Geliştirici",
            xp = 240,
            streak = 7,
            lastActiveDate = getTodayDateString(),
            isPremium = false,
            studyMinutes = 35,
            solvedQuestions = 14,
            completedLessons = 4,
            completedChallenges = 2,
            dailyGoalClaimedDate = "",
            currentActiveCourseId = "dart"
        )
    }

    val userProfileDataFlow: Flow<UserProfileData> = userStatsFlow.map { stats ->
        val level = calculateLevel(stats.xp)
        val levelTitle = getLevelTitle(level)
        val xpForNext = getXpForNextLevel(level)

        UserProfileData(
            username = stats.username,
            level = level,
            levelTitle = levelTitle,
            currentXp = stats.xp,
            xpForNextLevel = xpForNext,
            streakDays = stats.streak,
            isPremium = stats.isPremium,
            totalStudyMinutes = stats.studyMinutes,
            totalCompletedLessons = stats.completedLessons,
            totalSolvedQuizzes = stats.solvedQuestions,
            quizAccuracyPercentage = 88,
            codingSuccessPercentage = 92
        )
    }

    // ----------------------------------------------------
    // Courses & Progress
    // ----------------------------------------------------
    fun getLanguages() = CourseCatalog.languages

    fun getCourseSections(courseId: String) = CourseCatalog.getSections(courseId)

    fun getLessonsForCourse(courseId: String) = CourseCatalog.getLessonsForCourse(courseId)

    fun getProjects() = CourseCatalog.projects

    fun getAchievements() = CourseCatalog.defaultAchievements

    fun getCourseProgressFlow(courseId: String): Flow<CourseProgressInfo> {
        val totalLessons = CourseCatalog.getLessonsForCourse(courseId)
        return progressDao.getProgressByCourse(courseId).map { progressList ->
            val completedCount = progressList.count { it.status == LessonStatus.COMPLETED.name }
            val pct = if (totalLessons.isNotEmpty()) (completedCount.toFloat() / totalLessons.size.toFloat()) else 0f
            
            // Find next uncompleted lesson
            val completedIds = progressList.filter { it.status == LessonStatus.COMPLETED.name }.map { it.lessonId }.toSet()
            val nextLesson = totalLessons.firstOrNull { !completedIds.contains(it.id) }
            val lastCompleted = totalLessons.lastOrNull { completedIds.contains(it.id) }

            CourseProgressInfo(
                courseId = courseId,
                completedLessonsCount = completedCount,
                totalLessonsCount = totalLessons.size,
                progressPercentage = pct,
                lastCompletedLessonTitle = lastCompleted?.title,
                nextLessonId = nextLesson?.id ?: totalLessons.firstOrNull()?.id
            )
        }
    }

    fun getAllProgressFlow() = progressDao.getAllProgress()

    // ----------------------------------------------------
    // Actions & Rewards
    // ----------------------------------------------------
    suspend fun completeLesson(lessonId: String, courseId: String, score: Int = 100) {
        progressDao.upsertProgress(
            UserProgressEntity(
                lessonId = lessonId,
                courseId = courseId,
                status = LessonStatus.COMPLETED.name,
                quizScore = score,
                completedAt = System.currentTimeMillis()
            )
        )
        addXp(20)
        incrementCompletedLessons()
        checkAndUnlockAchievement("first_lesson")
    }

    suspend fun recordQuizFinished(lessonId: String, correctCount: Int, totalCount: Int) {
        val score = if (totalCount > 0) ((correctCount.toFloat() / totalCount.toFloat()) * 100).toInt() else 100
        progressDao.updateQuizScore(lessonId, score)
        addXp(10 * correctCount)
        incrementSolvedQuestions(correctCount)
        if (correctCount >= 5) {
            checkAndUnlockAchievement("quiz_master")
        }
    }

    suspend fun recordCodingChallengeFinished(lessonId: String, courseId: String) {
        progressDao.upsertProgress(
            UserProgressEntity(
                lessonId = lessonId,
                courseId = courseId,
                status = LessonStatus.COMPLETED.name,
                codingChallengeCompleted = true,
                completedAt = System.currentTimeMillis()
            )
        )
        addXp(30)
        incrementCompletedChallenges()
        checkAndUnlockAchievement("first_code")
    }

    suspend fun setPremium(isPremium: Boolean) {
        val stats = getOrCreateStats()
        statsDao.upsertStats(stats.copy(isPremium = isPremium))
    }

    suspend fun setActiveCourse(courseId: String) {
        val stats = getOrCreateStats()
        statsDao.upsertStats(stats.copy(currentActiveCourseId = courseId))
    }

    // ----------------------------------------------------
    // Notes & Favorites
    // ----------------------------------------------------
    val allNotesFlow: Flow<List<UserNoteEntity>> = notesDao.getAllNotes()

    suspend fun saveNote(lessonId: String, lessonTitle: String, courseId: String, content: String) {
        notesDao.saveNote(
            UserNoteEntity(
                lessonId = lessonId,
                lessonTitle = lessonTitle,
                courseId = courseId,
                noteContent = content,
                updatedAt = System.currentTimeMillis()
            )
        )
    }

    suspend fun getNote(lessonId: String) = notesDao.getNoteByLessonId(lessonId)

    val allFavoritesFlow: Flow<List<FavoriteEntity>> = favoritesDao.getAllFavorites()

    fun isFavorited(id: String) = favoritesDao.isFavorited(id)

    suspend fun toggleFavorite(id: String, type: String, courseId: String, title: String, subtitle: String, isFav: Boolean) {
        if (isFav) {
            favoritesDao.removeFavorite(id)
        } else {
            favoritesDao.addFavorite(
                FavoriteEntity(
                    id = id,
                    itemType = type,
                    courseId = courseId,
                    title = title,
                    subtitle = subtitle
                )
            )
        }
    }

    // ----------------------------------------------------
    // Mistakes & Personalized Review
    // ----------------------------------------------------
    val allMistakesFlow: Flow<List<MistakeEntity>> = mistakeDao.getAllMistakes()

    suspend fun recordMistake(
        questionId: String,
        lessonId: String,
        courseId: String,
        topicName: String,
        questionText: String,
        wrongChoice: String,
        correctChoice: String,
        explanation: String
    ) {
        val existing = mistakeDao.getMistake(questionId)
        val count = (existing?.mistakeCount ?: 0) + 1
        mistakeDao.recordMistake(
            MistakeEntity(
                questionId = questionId,
                lessonId = lessonId,
                courseId = courseId,
                topicName = topicName,
                questionText = questionText,
                wrongAnswerChosen = wrongChoice,
                correctAnswer = correctChoice,
                explanation = explanation,
                mistakeCount = count,
                lastOccurredAt = System.currentTimeMillis()
            )
        )
    }

    suspend fun clearMistake(questionId: String) {
        mistakeDao.clearMistake(questionId)
    }

    // ----------------------------------------------------
    // Achievements
    // ----------------------------------------------------
    val unlockedAchievementsFlow: Flow<List<UnlockedAchievementEntity>> = achievementDao.getAllUnlocked()

    private suspend fun checkAndUnlockAchievement(id: String) {
        achievementDao.unlock(UnlockedAchievementEntity(id))
    }

    // ----------------------------------------------------
    // Internal Helper Functions
    // ----------------------------------------------------
    private suspend fun getOrCreateStats(): UserStatsEntity {
        return statsDao.getUserStats() ?: UserStatsEntity(
            id = 1,
            username = "Geliştirici",
            xp = 240,
            streak = 7,
            lastActiveDate = getTodayDateString(),
            isPremium = false
        )
    }

    private suspend fun addXp(amount: Int) {
        val stats = getOrCreateStats()
        statsDao.upsertStats(stats.copy(xp = stats.xp + amount))
    }

    private suspend fun incrementCompletedLessons() {
        val stats = getOrCreateStats()
        statsDao.upsertStats(stats.copy(completedLessons = stats.completedLessons + 1))
    }

    private suspend fun incrementSolvedQuestions(count: Int) {
        val stats = getOrCreateStats()
        statsDao.upsertStats(stats.copy(solvedQuestions = stats.solvedQuestions + count))
    }

    private suspend fun incrementCompletedChallenges() {
        val stats = getOrCreateStats()
        statsDao.upsertStats(stats.copy(completedChallenges = stats.completedChallenges + 1))
    }

    private fun calculateLevel(xp: Int): Int = when {
        xp < 500 -> 1
        xp < 1200 -> 2
        xp < 2200 -> 3
        xp < 3800 -> 4
        xp < 6000 -> 5
        else -> 6
    }

    private fun getLevelTitle(level: Int): String = when (level) {
        1 -> "Level 1 – Çaylak (Beginner)"
        2 -> "Level 2 – Öğrenen (Learner)"
        3 -> "Level 3 – Kodlayıcı (Coder)"
        4 -> "Level 4 – Geliştirici (Developer)"
        5 -> "Level 5 – İleri Geliştirici (Advanced)"
        else -> "Level 6 – Usta (Expert)"
    }

    private fun getXpForNextLevel(level: Int): Int = when (level) {
        1 -> 500
        2 -> 1200
        3 -> 2200
        4 -> 3800
        5 -> 6000
        else -> 10000
    }

    private fun getTodayDateString(): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return sdf.format(Date())
    }
}
