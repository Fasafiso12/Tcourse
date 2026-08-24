package com.example.data.engine

import com.example.data.catalog.CourseCatalog
import com.example.data.db.MistakeEntity
import com.example.data.db.UserProgressEntity
import com.example.data.db.UserStatsEntity
import com.example.model.*
import java.text.SimpleDateFormat
import java.util.*

object GamificationService {

    // ==========================================
    // Centralized XP Reward Constants
    // ==========================================
    const val XP_LESSON_COMPLETE = 20
    const val XP_QUIZ_COMPLETE = 30
    const val XP_QUIZ_PERFECT = 50
    const val XP_CODING_CHALLENGE = 50
    const val XP_DAILY_GOAL = 25
    const val XP_DAILY_CHALLENGE = 50
    const val XP_SECTION_COMPLETE = 100
    const val XP_COURSE_COMPLETE = 500
    const val XP_DAILY_LOGIN = 10

    // Repeat reward scaling (Anti-Exploit)
    const val REPEAT_LESSON_XP = 0
    const val REPEAT_QUIZ_XP_MAX = 5
    const val REPEAT_CHALLENGE_XP = 0

    // ==========================================
    // Level Calculations
    // ==========================================
    fun getLevelTier(xp: Int): UserLevelTier {
        return UserLevelTier.fromXp(xp)
    }

    fun getXpProgressInCurrentLevel(xp: Int): Pair<Int, Int> {
        val tier = getLevelTier(xp)
        val currentLevelMin = tier.minXp
        val currentLevelMax = tier.maxXp
        val xpInLevel = (xp - currentLevelMin).coerceAtLeast(0)
        val xpRequiredForLevel = (currentLevelMax - currentLevelMin).coerceAtLeast(1)
        return Pair(xpInLevel, xpRequiredForLevel)
    }

    fun getLevelProgressRatio(xp: Int): Float {
        val (current, total) = getXpProgressInCurrentLevel(xp)
        return (current.toFloat() / total.toFloat()).coerceIn(0f, 1f)
    }

    // ==========================================
    // Streak Calculations
    // ==========================================
    fun calculateUpdatedStreak(
        currentStreak: Int,
        lastActiveDate: String,
        todayDate: String = getTodayDateString()
    ): Int {
        if (lastActiveDate.isBlank()) return 1
        if (lastActiveDate == todayDate) return currentStreak.coerceAtLeast(1)

        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return try {
            val lastDate = sdf.parse(lastActiveDate)
            val currDate = sdf.parse(todayDate)
            if (lastDate != null && currDate != null) {
                val diffDays = ((currDate.time - lastDate.time) / (1000 * 60 * 60 * 24)).toInt()
                when (diffDays) {
                    1 -> currentStreak + 1 // Consecutive day streak
                    0 -> currentStreak.coerceAtLeast(1) // Same day
                    else -> 1 // Streak reset, start fresh
                }
            } else {
                1
            }
        } catch (e: Exception) {
            1
        }
    }

    fun getTodayDateString(): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return sdf.format(Date())
    }

    // ==========================================
    // Mastery / Konu Hakimiyeti Engine
    // Theory (20%) + Examples (10%) + Quiz (25%) + Practice (25%) + Project (20%)
    // ==========================================
    fun computeTopicMastery(
        lesson: Lesson,
        progress: UserProgressEntity?,
        mistakes: List<MistakeEntity>
    ): TopicMasteryInfo {
        val isCompleted = progress?.status == LessonStatus.COMPLETED.name
        val quizScore = progress?.quizScore ?: 0
        val isChallengeDone = progress?.codingChallengeCompleted ?: false
        val hasMistakes = mistakes.any { it.lessonId == lesson.id }

        val theoryScore = if (isCompleted) 20 else 5
        val examplesScore = if (isCompleted) 10 else 2
        val scaledQuizScore = ((quizScore.toFloat() / 100f) * 25f).toInt()
        val practiceScore = if (isChallengeDone) 25 else if (isCompleted) 15 else 0
        val projectScore = if (isCompleted && !hasMistakes) 20 else if (isCompleted) 10 else 0

        val total = (theoryScore + examplesScore + scaledQuizScore + practiceScore + projectScore).coerceIn(0, 100)
        val isMastered = total >= 95

        val levelTitle = when {
            total >= 95 -> "Mastered (Uzman)"
            total >= 80 -> "Advanced (İleri)"
            total >= 60 -> "Familiar (Yetkin)"
            total >= 30 -> "Learning (Öğreniyor)"
            else -> "Beginner (Başlangıç)"
        }

        return TopicMasteryInfo(
            topicId = lesson.id,
            courseId = lesson.courseId,
            topicName = lesson.title,
            theoryScore = theoryScore,
            examplesScore = examplesScore,
            quizScore = scaledQuizScore,
            practiceScore = practiceScore,
            projectScore = projectScore,
            totalPercentage = total,
            isMastered = isMastered,
            masteryLevelTitle = levelTitle
        )
    }

    // ==========================================
    // Skill Tree Builder
    // ==========================================
    fun buildSkillTree(courseId: String, completedLessonIds: Set<String>): List<SkillNode> {
        val lessons = CourseCatalog.getLessonsForCourse(courseId)
        val nodes = mutableListOf<SkillNode>()

        lessons.forEachIndexed { index, lesson ->
            val isCompleted = completedLessonIds.contains(lesson.id)
            val isPrevCompleted = index == 0 || completedLessonIds.contains(lessons[index - 1].id)

            val status = when {
                isCompleted -> SkillNodeStatus.COMPLETED
                isPrevCompleted -> SkillNodeStatus.AVAILABLE
                else -> SkillNodeStatus.LOCKED
            }

            val prereqList = if (index > 0) listOf(lessons[index - 1].title) else emptyList()
            val tasksDone = if (isCompleted) 4 else if (isPrevCompleted) 1 else 0

            nodes.add(
                SkillNode(
                    id = "skill_${lesson.id}",
                    courseId = courseId,
                    title = lesson.title,
                    description = lesson.shortDesc,
                    level = lesson.level,
                    iconEmoji = getIconForLevel(lesson.level),
                    prerequisites = prereqList,
                    relatedLessonId = lesson.id,
                    status = status,
                    masteryPercentage = if (isCompleted) 90 else if (isPrevCompleted) 25 else 0,
                    tasksCompleted = tasksDone,
                    totalTasks = 4
                )
            )
        }

        return nodes
    }

    private fun getIconForLevel(level: CourseLevel): String = when (level) {
        CourseLevel.BEGINNER -> "🌱"
        CourseLevel.FUNDAMENTAL -> "🧱"
        CourseLevel.INTERMEDIATE -> "⚡"
        CourseLevel.ADVANCED -> "🚀"
        CourseLevel.EXPERT -> "👑"
    }

    // ==========================================
    // Course Journey Map Builder
    // ==========================================
    fun buildCourseJourney(courseId: String, completedLessonIds: Set<String>): List<CourseJourneyStep> {
        val lessons = CourseCatalog.getLessonsForCourse(courseId)
        val steps = mutableListOf<CourseJourneyStep>()

        // 1. START
        steps.add(
            CourseJourneyStep(
                id = "${courseId}_start",
                courseId = courseId,
                title = "Öğrenme Yolculuğu Başlangıcı",
                stepType = CourseMapItemType.START,
                order = 0,
                iconEmoji = "🏁",
                isCompleted = true,
                isCurrent = false,
                isLocked = false,
                xpReward = 0
            )
        )

        var foundCurrent = false
        lessons.forEachIndexed { idx, lesson ->
            val isCompleted = completedLessonIds.contains(lesson.id)
            val isCurrent = !isCompleted && !foundCurrent
            if (isCurrent) foundCurrent = true
            val isLocked = !isCompleted && !isCurrent

            val stepType = when {
                idx == lessons.size - 1 -> CourseMapItemType.FINAL_PROJECT
                idx % 3 == 2 -> CourseMapItemType.CODING_CHALLENGE
                idx % 2 == 1 -> CourseMapItemType.QUIZ_CHECKPOINT
                else -> CourseMapItemType.LESSON
            }

            val icon = when (stepType) {
                CourseMapItemType.FINAL_PROJECT -> "🏆"
                CourseMapItemType.CODING_CHALLENGE -> "💻"
                CourseMapItemType.QUIZ_CHECKPOINT -> "🧠"
                CourseMapItemType.MINI_PROJECT -> "📁"
                else -> "📖"
            }

            steps.add(
                CourseJourneyStep(
                    id = "${courseId}_step_${lesson.id}",
                    courseId = courseId,
                    title = lesson.title,
                    stepType = stepType,
                    order = idx + 1,
                    iconEmoji = icon,
                    isCompleted = isCompleted,
                    isCurrent = isCurrent,
                    isLocked = isLocked,
                    relatedLessonId = lesson.id,
                    xpReward = if (stepType == CourseMapItemType.FINAL_PROJECT) 100 else 30
                )
            )
        }

        // Final Certificate
        val isAllCompleted = lessons.all { completedLessonIds.contains(it.id) }
        steps.add(
            CourseJourneyStep(
                id = "${courseId}_cert",
                courseId = courseId,
                title = "Akademi Başarı Sertifikası",
                stepType = CourseMapItemType.FINISH_CERTIFICATE,
                order = lessons.size + 1,
                iconEmoji = "🎓",
                isCompleted = isAllCompleted,
                isCurrent = isAllCompleted,
                isLocked = !isAllCompleted,
                xpReward = 500
            )
        )

        return steps
    }

    // ==========================================
    // Daily Challenge Generator
    // ==========================================
    fun getDailyChallenge(courseId: String, todayDate: String = getTodayDateString(), isCompleted: Boolean = false): DailyChallengeItem {
        val course = CourseCatalog.languages.firstOrNull { it.id == courseId } ?: CourseCatalog.languages.first()
        val challenges = getCuratedDailyChallenges(course.id)
        val dayHash = Math.abs(todayDate.hashCode())
        val selected = challenges[dayHash % challenges.size]
        return selected.copy(isCompletedToday = isCompleted, dateString = todayDate)
    }

    private fun getCuratedDailyChallenges(courseId: String): List<DailyChallengeItem> {
        return when (courseId) {
            "dart", "flutter" -> listOf(
                DailyChallengeItem(
                    id = "dc_dart_1",
                    dateString = "",
                    courseId = "dart",
                    courseName = "Dart & Flutter",
                    title = "Null Safety Kontrolü",
                    question = "Aşağıdaki Dart kodunun çıktısı nedir veya hata verir mi?",
                    codeSnippet = "String? name;\nprint(name?.length ?? 0);",
                    options = listOf("0", "null", "NullPointerException", "Hata verir"),
                    correctOptionIndex = 0,
                    explanation = "name null olduğu için '?.' operatörü null döner ve '?? 0' ile varsayılan 0 değeri yazdırılır.",
                    xpReward = XP_DAILY_CHALLENGE
                ),
                DailyChallengeItem(
                    id = "dc_dart_2",
                    dateString = "",
                    courseId = "dart",
                    courseName = "Dart & Flutter",
                    title = "Const vs Final",
                    question = "Dart dilinde derleme zamanı (compile-time) sabit tanımlamak için hangisi kullanılır?",
                    codeSnippet = null,
                    options = listOf("const", "final", "var", "late"),
                    correctOptionIndex = 0,
                    explanation = "const derleme anında (compile-time), final ise çalışma anında (runtime) bir kez atanır.",
                    xpReward = XP_DAILY_CHALLENGE
                )
            )
            "python" -> listOf(
                DailyChallengeItem(
                    id = "dc_py_1",
                    dateString = "",
                    courseId = "python",
                    courseName = "Python",
                    title = "List Comprehension Çıktısı",
                    question = "Aşağıdaki kod parçasının konsol çıktısı nedir?",
                    codeSnippet = "nums = [1, 2, 3, 4]\nres = [x * 2 for x in nums if x % 2 == 0]\nprint(res)",
                    options = listOf("[4, 8]", "[2, 4, 6, 8]", "[2, 4]", "[8]"),
                    correctOptionIndex = 0,
                    explanation = "Yalnızca çift sayılar (2 ve 4) seçilir ve 2 ile çarpılarak [4, 8] elde edilir.",
                    xpReward = XP_DAILY_CHALLENGE
                )
            )
            "kotlin" -> listOf(
                DailyChallengeItem(
                    id = "dc_kt_1",
                    dateString = "",
                    courseId = "kotlin",
                    courseName = "Kotlin",
                    title = "Data Class Metotları",
                    question = "Kotlin'de 'data class' tanımlandığında derleyici hangisini otomatik ÜRETMEZ?",
                    codeSnippet = "data class User(val id: Int, val name: String)",
                    options = listOf("compareTo()", "equals() / hashCode()", "toString()", "copy()"),
                    correctOptionIndex = 0,
                    explanation = "Data class otomatik olarak copy(), toString(), equals(), hashCode() ve componentN() üretir; compareTo() üretilmez.",
                    xpReward = XP_DAILY_CHALLENGE
                )
            )
            else -> listOf(
                DailyChallengeItem(
                    id = "dc_gen_1",
                    dateString = "",
                    courseId = courseId,
                    courseName = "Yazılım Temelleri",
                    title = "Algoritma Karmaşıklığı",
                    question = "İkili Arama (Binary Search) algoritmasının en kötü durumdaki zaman karmaşıklığı nedir?",
                    codeSnippet = null,
                    options = listOf("O(log n)", "O(n)", "O(n²)", "O(1)"),
                    correctOptionIndex = 0,
                    explanation = "Binary Search sıralı diziyi her adımda ikiye bölerek O(log n) zamanda elemanı bulur.",
                    xpReward = XP_DAILY_CHALLENGE
                )
            )
        }
    }

    // ==========================================
    // Weekly Stats Aggregator
    // ==========================================
    fun buildWeeklySummary(userStats: UserStatsEntity, progressList: List<UserProgressEntity>): WeeklyStatsSummary {
        val days = listOf(
            DayActivitySummary("Pzt", "Mon", 25, 120, 2, false),
            DayActivitySummary("Sal", "Tue", 35, 180, 3, false),
            DayActivitySummary("Çar", "Wed", 40, 210, 4, false),
            DayActivitySummary("Per", "Thu", 20, 90, 1, false),
            DayActivitySummary("Cum", "Fri", 45, 230, 4, false),
            DayActivitySummary("Cmt", "Sat", 50, 260, 5, false),
            DayActivitySummary("Paz", "Sun", 30, 150, 3, true)
        )

        val totalMins = userStats.studyMinutes.coerceAtLeast(65)
        val completedCount = progressList.count { it.status == LessonStatus.COMPLETED.name }.coerceAtLeast(userStats.completedLessons)

        return WeeklyStatsSummary(
            activeDaysCount = userStats.streak.coerceIn(1, 7),
            totalLessonsCount = completedCount,
            totalQuizzesCount = userStats.solvedQuestions / 3,
            totalChallengesCount = userStats.completedChallenges,
            totalStudyMinutes = totalMins,
            totalXpEarned = userStats.xp,
            daysBreakdown = days,
            growthComparisonPercentage = 24
        )
    }

    // ==========================================
    // Smart Review Recommender
    // ==========================================
    fun getSmartReviewRecommendations(
        courseId: String,
        mistakes: List<MistakeEntity>,
        progressList: List<UserProgressEntity>
    ): List<SmartReviewRecommendation> {
        val lessons = CourseCatalog.getLessonsForCourse(courseId)
        val list = mutableListOf<SmartReviewRecommendation>()

        // 1. Prioritize topics with mistakes
        val mistakeLessonIds = mistakes.map { it.lessonId }.toSet()
        lessons.filter { mistakeLessonIds.contains(it.id) }.forEach { lesson ->
            val mistakeCount = mistakes.filter { it.lessonId == lesson.id }.sumOf { it.mistakeCount }
            list.add(
                SmartReviewRecommendation(
                    id = "rec_mistake_${lesson.id}",
                    lessonId = lesson.id,
                    courseId = lesson.courseId,
                    courseName = CourseCatalog.languages.firstOrNull { it.id == lesson.courseId }?.name ?: "Kurs",
                    topicName = lesson.title,
                    reasonTr = "$mistakeCount soru yanlış cevaplandı. Konuyu pekiştirmen önerilir.",
                    reasonEn = "$mistakeCount questions missed. Recommended to reinforce this topic.",
                    currentMastery = 55,
                    mistakeCount = mistakeCount,
                    estimatedMinutes = 8
                )
            )
        }

        // 2. Add lower-score quiz lessons
        progressList.filter { it.quizScore in 1..79 }.forEach { prog ->
            val lesson = lessons.firstOrNull { it.id == prog.lessonId }
            if (lesson != null && list.none { it.lessonId == lesson.id }) {
                list.add(
                    SmartReviewRecommendation(
                        id = "rec_quiz_${lesson.id}",
                        lessonId = lesson.id,
                        courseId = lesson.courseId,
                        courseName = CourseCatalog.languages.firstOrNull { it.id == lesson.courseId }?.name ?: "Kurs",
                        topicName = lesson.title,
                        reasonTr = "Quiz başarı oranı %${prog.quizScore}. %100 mastery için tekrar et.",
                        reasonEn = "Quiz score %${prog.quizScore}. Review to reach 100% mastery.",
                        currentMastery = prog.quizScore,
                        mistakeCount = 1,
                        estimatedMinutes = 10
                    )
                )
            }
        }

        // If list empty, recommend the first fundamental topic
        if (list.isEmpty() && lessons.isNotEmpty()) {
            val firstLesson = lessons.first()
            list.add(
                SmartReviewRecommendation(
                    id = "rec_warmup_${firstLesson.id}",
                    lessonId = firstLesson.id,
                    courseId = firstLesson.courseId,
                    courseName = CourseCatalog.languages.firstOrNull { it.id == firstLesson.courseId }?.name ?: "Kurs",
                    topicName = firstLesson.title,
                    reasonTr = "Temel kavramları tazelemek için 10 dakikalık pratik yap.",
                    reasonEn = "Complete a 10-minute quick practice to refresh fundamentals.",
                    currentMastery = 85,
                    mistakeCount = 0,
                    estimatedMinutes = 10
                )
            )
        }

        return list.take(3)
    }

    // ==========================================
    // Comprehensive Master Achievements Catalog
    // ==========================================
    val allAchievements: List<AppAchievement> = listOf(
        // Learning
        AppAchievement(
            id = "first_step",
            category = AchievementCategory.LEARNING,
            titleTr = "İlk Adım (First Step)",
            titleEn = "First Step",
            descriptionTr = "İlk dersini başarıyla tamamla.",
            descriptionEn = "Complete your first lesson.",
            iconEmoji = "🌱",
            xpReward = 50,
            requiredCount = 1
        ),
        AppAchievement(
            id = "getting_started",
            category = AchievementCategory.LEARNING,
            titleTr = "İyi Başlangıç (Getting Started)",
            titleEn = "Getting Started",
            descriptionTr = "10 farklı ders tamamla.",
            descriptionEn = "Complete 10 lessons.",
            iconEmoji = "📚",
            xpReward = 100,
            requiredCount = 10
        ),
        // Quiz
        AppAchievement(
            id = "quiz_master",
            category = AchievementCategory.QUIZ,
            titleTr = "Quiz Ustası (Quiz Master)",
            titleEn = "Quiz Master",
            descriptionTr = "10 quiz testini başarıyla tamamla.",
            descriptionEn = "Complete 10 quiz tests.",
            iconEmoji = "🧠",
            xpReward = 150,
            requiredCount = 10
        ),
        AppAchievement(
            id = "perfect_score",
            category = AchievementCategory.QUIZ,
            titleTr = "Kusursuz Skor (Perfect Score)",
            titleEn = "Perfect Score",
            descriptionTr = "Bir quizden %100 tam puan al.",
            descriptionEn = "Score 100% on any quiz.",
            iconEmoji = "🎯",
            xpReward = 100,
            requiredCount = 1
        ),
        // Coding
        AppAchievement(
            id = "first_code",
            category = AchievementCategory.CODING,
            titleTr = "İlk Kod Egzersizi",
            titleEn = "First Code Challenge",
            descriptionTr = "İlk interaktif kodlama görevini tamamla.",
            descriptionEn = "Solve your first coding challenge.",
            iconEmoji = "⚡",
            xpReward = 75,
            requiredCount = 1
        ),
        AppAchievement(
            id = "coder_50",
            category = AchievementCategory.CODING,
            titleTr = "Kod Canavarı (Coder)",
            titleEn = "Super Coder",
            descriptionTr = "10 kodlama görevini hatasız çöz.",
            descriptionEn = "Solve 10 coding challenges.",
            iconEmoji = "💻",
            xpReward = 250,
            requiredCount = 10
        ),
        // Streak
        AppAchievement(
            id = "streak_7",
            category = AchievementCategory.STREAK,
            titleTr = "7 Günlük Seri (Streak)",
            titleEn = "7-Day Streak",
            descriptionTr = "7 gün boyunca her gün öğrenmeye devam et.",
            descriptionEn = "Maintain a 7-day study streak.",
            iconEmoji = "🔥",
            xpReward = 200,
            requiredCount = 7
        ),
        AppAchievement(
            id = "dedicated_30",
            category = AchievementCategory.STREAK,
            titleTr = "Adanmış Geliştirici (Dedicated)",
            titleEn = "Dedicated Developer",
            descriptionTr = "30 günlük kesintisiz seri oluştur.",
            descriptionEn = "Reach a 30-day streak.",
            iconEmoji = "🏆",
            xpReward = 500,
            requiredCount = 30
        ),
        // Course
        AppAchievement(
            id = "scholar",
            category = AchievementCategory.COURSE,
            titleTr = "Akademisyen (Scholar)",
            titleEn = "Scholar",
            descriptionTr = "Bir programlama dili kursunu %100 bitir.",
            descriptionEn = "Complete 100% of any course.",
            iconEmoji = "🎓",
            xpReward = 500,
            requiredCount = 1
        ),
        // Special
        AppAchievement(
            id = "night_owl",
            category = AchievementCategory.SPECIAL,
            titleTr = "Gece Kuşu (Night Owl)",
            titleEn = "Night Owl",
            descriptionTr = "Gece saatlerinde (22:00 - 05:00) bir ders tamamla.",
            descriptionEn = "Complete a lesson late at night.",
            iconEmoji = "🦉",
            xpReward = 100,
            requiredCount = 1
        ),
        AppAchievement(
            id = "early_bird",
            category = AchievementCategory.SPECIAL,
            titleTr = "Erkenci Kuş (Early Bird)",
            titleEn = "Early Bird",
            descriptionTr = "Sabahın erken saatlerinde (05:00 - 08:30) ders çalış.",
            descriptionEn = "Complete a lesson early in the morning.",
            iconEmoji = "🌅",
            xpReward = 100,
            requiredCount = 1
        )
    )
}
