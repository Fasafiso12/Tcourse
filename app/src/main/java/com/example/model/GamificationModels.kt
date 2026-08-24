package com.example.model

/**
 * Level progression tiers (Level 1 to Level 10)
 */
enum class UserLevelTier(
    val level: Int,
    val titleTr: String,
    val titleEn: String,
    val minXp: Int,
    val maxXp: Int,
    val badgeEmoji: String
) {
    LEVEL_1(1, "Çaylak", "Beginner", 0, 499, "🌱"),
    LEVEL_2(2, "Öğrenen", "Learner", 500, 1199, "📖"),
    LEVEL_3(3, "Çırak", "Apprentice", 1200, 2199, "🔨"),
    LEVEL_4(4, "Geliştirici", "Developer", 2200, 3499, "💻"),
    LEVEL_5(5, "Yetenekli", "Skilled", 3500, 4999, "⚡"),
    LEVEL_6(6, "Uzman", "Specialist", 5000, 6999, "🎯"),
    LEVEL_7(7, "İleri Düzey", "Advanced", 7000, 9499, "🚀"),
    LEVEL_8(8, "Usta", "Expert", 9500, 12499, "👑"),
    LEVEL_9(9, "Büyük Usta", "Master", 12500, 15999, "🔮"),
    LEVEL_10(10, "Efsanevi", "Grand Master", 16000, 999999, "🌌");

    companion object {
        fun fromXp(xp: Int): UserLevelTier {
            val safeXp = xp.coerceAtLeast(0)
            return values().lastOrNull { safeXp >= it.minXp } ?: LEVEL_1
        }

        fun fromLevel(level: Int): UserLevelTier {
            return values().firstOrNull { it.level == level } ?: LEVEL_1
        }
    }
}

/**
 * Achievement Categories
 */
enum class AchievementCategory(val id: String, val titleTr: String, val titleEn: String, val iconEmoji: String) {
    LEARNING("learning", "Öğrenim", "Learning", "📚"),
    QUIZ("quiz", "Quiz & Sınav", "Quiz", "🧠"),
    CODING("coding", "Kodlama", "Coding", "💻"),
    STREAK("streak", "Seri & İstikrar", "Streak", "🔥"),
    COURSE("course", "Kurs & Mezuniyet", "Course", "🎓"),
    SPECIAL("special", "Özel & Prestij", "Special", "⭐")
}

/**
 * Rich Achievement definition
 */
data class AppAchievement(
    val id: String,
    val category: AchievementCategory,
    val titleTr: String,
    val titleEn: String,
    val descriptionTr: String,
    val descriptionEn: String,
    val iconEmoji: String,
    val xpReward: Int,
    val requiredCount: Int = 1,
    val currentProgress: Int = 0,
    val isUnlocked: Boolean = false,
    val unlockedAt: Long? = null
)

/**
 * Skill Tree Node state
 */
enum class SkillNodeStatus {
    LOCKED,
    AVAILABLE,
    IN_PROGRESS,
    COMPLETED,
    MASTERED
}

/**
 * Skill Tree Node model
 */
data class SkillNode(
    val id: String,
    val courseId: String,
    val title: String,
    val description: String,
    val level: CourseLevel,
    val iconEmoji: String,
    val prerequisites: List<String> = emptyList(),
    val relatedLessonId: String? = null,
    val status: SkillNodeStatus = SkillNodeStatus.LOCKED,
    val masteryPercentage: Int = 0,
    val tasksCompleted: Int = 0,
    val totalTasks: Int = 4
)

/**
 * Course Journey Map item types
 */
enum class CourseMapItemType {
    START,
    LESSON,
    QUIZ_CHECKPOINT,
    CODING_CHALLENGE,
    MINI_PROJECT,
    FINAL_PROJECT,
    FINISH_CERTIFICATE
}

data class CourseJourneyStep(
    val id: String,
    val courseId: String,
    val title: String,
    val stepType: CourseMapItemType,
    val order: Int,
    val iconEmoji: String,
    val isCompleted: Boolean,
    val isCurrent: Boolean,
    val isLocked: Boolean,
    val relatedLessonId: String? = null,
    val xpReward: Int = 20
)

/**
 * Multi-factor Topic Mastery
 */
data class TopicMasteryInfo(
    val topicId: String,
    val courseId: String,
    val topicName: String,
    val theoryScore: Int = 0,     // 0-20
    val examplesScore: Int = 0,   // 0-10
    val quizScore: Int = 0,       // 0-25
    val practiceScore: Int = 0,   // 0-25
    val projectScore: Int = 0,    // 0-20
    val totalPercentage: Int = 0, // 0-100
    val isMastered: Boolean = false,
    val masteryLevelTitle: String = "Başlangıç"
) {
    val isWeakArea: Boolean get() = totalPercentage in 1..69 || (quizScore in 1..14)
}

/**
 * Daily Interactive Challenge
 */
data class DailyChallengeItem(
    val id: String,
    val dateString: String,
    val courseId: String,
    val courseName: String,
    val title: String,
    val question: String,
    val codeSnippet: String? = null,
    val options: List<String>,
    val correctOptionIndex: Int,
    val explanation: String,
    val xpReward: Int = 50,
    val isCompletedToday: Boolean = false
)

/**
 * Weekly Activity day breakdown
 */
data class DayActivitySummary(
    val dayNameTr: String, // Pzt, Sal, Çar, Per, Cum, Cmt, Paz
    val dayNameEn: String,
    val studyMinutes: Int,
    val xpEarned: Int,
    val lessonsCompleted: Int,
    val isToday: Boolean
)

data class WeeklyStatsSummary(
    val activeDaysCount: Int = 6,
    val totalLessonsCount: Int = 18,
    val totalQuizzesCount: Int = 7,
    val totalChallengesCount: Int = 9,
    val totalStudyMinutes: Int = 215,
    val totalXpEarned: Int = 890,
    val daysBreakdown: List<DayActivitySummary> = emptyList(),
    val growthComparisonPercentage: Int? = 18 // null if insufficient data
)

/**
 * Smart Review recommendation
 */
data class SmartReviewRecommendation(
    val id: String,
    val lessonId: String,
    val courseId: String,
    val courseName: String,
    val topicName: String,
    val reasonTr: String,
    val reasonEn: String,
    val currentMastery: Int,
    val mistakeCount: Int,
    val estimatedMinutes: Int = 10
)

/**
 * XP Gain Animation Event
 */
data class XpGainEvent(
    val id: Long = System.currentTimeMillis(),
    val amount: Int,
    val sourceTitle: String
)

/**
 * Level Up Animation Event
 */
data class LevelUpEvent(
    val oldTier: UserLevelTier,
    val newTier: UserLevelTier,
    val totalXp: Int
)
