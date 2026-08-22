package com.example.data.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ProgressDao {
    @Query("SELECT * FROM user_progress")
    fun getAllProgress(): Flow<List<UserProgressEntity>>

    @Query("SELECT * FROM user_progress WHERE courseId = :courseId")
    fun getProgressByCourse(courseId: String): Flow<List<UserProgressEntity>>

    @Query("SELECT * FROM user_progress WHERE lessonId = :lessonId LIMIT 1")
    suspend fun getProgressForLesson(lessonId: String): UserProgressEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertProgress(progress: UserProgressEntity)

    @Query("UPDATE user_progress SET status = :status, completedAt = :timestamp WHERE lessonId = :lessonId")
    suspend fun updateLessonStatus(lessonId: String, status: String, timestamp: Long = System.currentTimeMillis())

    @Query("UPDATE user_progress SET quizScore = :score WHERE lessonId = :lessonId")
    suspend fun updateQuizScore(lessonId: String, score: Int)
}

@Dao
interface UserStatsDao {
    @Query("SELECT * FROM user_stats WHERE id = 1 LIMIT 1")
    fun getUserStatsFlow(): Flow<UserStatsEntity?>

    @Query("SELECT * FROM user_stats WHERE id = 1 LIMIT 1")
    suspend fun getUserStats(): UserStatsEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertStats(stats: UserStatsEntity)

    @Query("UPDATE user_stats SET isPremium = :isPremium WHERE id = 1")
    suspend fun setPremiumStatus(isPremium: Boolean)

    @Query("UPDATE user_stats SET currentActiveCourseId = :courseId WHERE id = 1")
    suspend fun setActiveCourse(courseId: String)
}

@Dao
interface UserNotesDao {
    @Query("SELECT * FROM user_notes ORDER BY updatedAt DESC")
    fun getAllNotes(): Flow<List<UserNoteEntity>>

    @Query("SELECT * FROM user_notes WHERE lessonId = :lessonId LIMIT 1")
    suspend fun getNoteByLessonId(lessonId: String): UserNoteEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveNote(note: UserNoteEntity)

    @Query("DELETE FROM user_notes WHERE lessonId = :lessonId")
    suspend fun deleteNoteByLessonId(lessonId: String)
}

@Dao
interface FavoritesDao {
    @Query("SELECT * FROM user_favorites ORDER BY createdAt DESC")
    fun getAllFavorites(): Flow<List<FavoriteEntity>>

    @Query("SELECT EXISTS(SELECT 1 FROM user_favorites WHERE id = :id)")
    fun isFavorited(id: String): Flow<Boolean>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorite(fav: FavoriteEntity)

    @Query("DELETE FROM user_favorites WHERE id = :id")
    suspend fun removeFavorite(id: String)
}

@Dao
interface MistakeDao {
    @Query("SELECT * FROM mistake_records ORDER BY mistakeCount DESC, lastOccurredAt DESC")
    fun getAllMistakes(): Flow<List<MistakeEntity>>

    @Query("SELECT * FROM mistake_records WHERE questionId = :questionId LIMIT 1")
    suspend fun getMistake(questionId: String): MistakeEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun recordMistake(mistake: MistakeEntity)

    @Query("DELETE FROM mistake_records WHERE questionId = :questionId")
    suspend fun clearMistake(questionId: String)
}

@Dao
interface AchievementDao {
    @Query("SELECT * FROM unlocked_achievements")
    fun getAllUnlocked(): Flow<List<UnlockedAchievementEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun unlock(achievement: UnlockedAchievementEntity)
}
