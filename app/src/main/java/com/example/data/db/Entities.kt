package com.example.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_progress")
data class UserProgressEntity(
    @PrimaryKey
    val lessonId: String,
    val courseId: String,
    val status: String, // NOT_STARTED, IN_PROGRESS, COMPLETED
    val quizScore: Int = 0,
    val codingChallengeCompleted: Boolean = false,
    val completedAt: Long = 0L
)

@Entity(tableName = "user_stats")
data class UserStatsEntity(
    @PrimaryKey
    val id: Int = 1,
    val username: String = "Geliştirici",
    val xp: Int = 0,
    val streak: Int = 1,
    val lastActiveDate: String = "",
    val isPremium: Boolean = false,
    val studyMinutes: Int = 0,
    val solvedQuestions: Int = 0,
    val completedLessons: Int = 0,
    val completedChallenges: Int = 0,
    val dailyGoalClaimedDate: String = "",
    val currentActiveCourseId: String = "dart"
)

@Entity(tableName = "user_notes")
data class UserNoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val lessonId: String,
    val lessonTitle: String,
    val courseId: String,
    val noteContent: String,
    val updatedAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "user_favorites")
data class FavoriteEntity(
    @PrimaryKey
    val id: String, // e.g., "lesson_dart_intro" or "project_py_calc"
    val itemType: String, // "LESSON", "SNIPPET", "PROJECT", "QUESTION"
    val courseId: String,
    val title: String,
    val subtitle: String,
    val createdAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "mistake_records")
data class MistakeEntity(
    @PrimaryKey
    val questionId: String,
    val lessonId: String,
    val courseId: String,
    val topicName: String,
    val questionText: String,
    val wrongAnswerChosen: String,
    val correctAnswer: String,
    val explanation: String,
    val mistakeCount: Int = 1,
    val lastOccurredAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "unlocked_achievements")
data class UnlockedAchievementEntity(
    @PrimaryKey
    val achievementId: String,
    val unlockedAt: Long = System.currentTimeMillis()
)
