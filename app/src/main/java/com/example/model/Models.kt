package com.example.model

enum class CourseLevel(val displayName: String, val order: Int) {
    BEGINNER("Başlangıç (Beginner)", 1),
    FUNDAMENTAL("Temel (Fundamental)", 2),
    INTERMEDIATE("Orta (Intermediate)", 3),
    ADVANCED("İleri (Advanced)", 4),
    EXPERT("Uzman (Expert)", 5)
}

enum class LessonStatus {
    NOT_STARTED,
    IN_PROGRESS,
    COMPLETED
}

enum class QuestionType {
    MULTIPLE_CHOICE,
    TRUE_FALSE,
    FILL_BLANK,
    GUESS_OUTPUT,
    FIND_BUG,
    CODE_MATCH
}

data class TopicQAItem(
    val question: String,
    val answer: String
)

data class ProgrammingLanguage(
    val id: String,
    val name: String,
    val tag: String,
    val iconEmoji: String,
    val colorHex: Long,
    val shortDescription: String,
    val targetAudience: String,
    val popularUses: List<String>,
    val totalLessonsCount: Int = 10,
    val isPopular: Boolean = false,
    val drawableRes: Int? = null
)

data class CourseSection(
    val id: String,
    val courseId: String,
    val title: String,
    val level: CourseLevel,
    val order: Int,
    val description: String,
    val prerequisites: List<String> = emptyList(),
    val learningObjectives: List<String> = emptyList()
)

data class Lesson(
    val id: String,
    val courseId: String,
    val sectionId: String,
    val title: String,
    val shortDesc: String,
    val level: CourseLevel,
    val order: Int,
    val isPremium: Boolean, // First 2 lessons are false (Free), 3rd+ are true (Premium)
    val learningObjectives: List<String> = emptyList(),
    val prerequisites: List<String> = emptyList(),
    val subtopics: List<String> = emptyList(),
    val detailedExplanation: List<LessonContentBlock>,
    val codeExample: String,
    val codeExplanation: String,
    val realWorldExample: String? = null,
    val practicalTask: String? = null,
    val starterPlaygroundCode: String,
    val miniQuestion: MiniQuestion? = null,
    val codingChallenge: CodingChallenge? = null,
    val quizQuestions: List<QuizQuestion> = emptyList(),
    val qaItems: List<TopicQAItem> = emptyList(),
    val completionCriteria: List<String> = emptyList(),
    val miniProject: ProjectItem? = null
)

data class LessonContentBlock(
    val subtitle: String,
    val body: String,
    val codeSnippet: String? = null,
    val tip: String? = null
)

data class MiniQuestion(
    val id: String,
    val question: String,
    val codeSnippet: String? = null,
    val options: List<String>,
    val correctIndex: Int,
    val explanation: String
)

data class QuizQuestion(
    val id: String,
    val lessonId: String,
    val questionType: QuestionType,
    val questionText: String,
    val codeSnippet: String? = null,
    val options: List<String>,
    val correctOptionIndex: Int,
    val explanationRight: String,
    val explanationWrong: String,
    val reviewTopic: String
)

data class CodingChallenge(
    val id: String,
    val lessonId: String,
    val title: String,
    val instructions: String,
    val exampleInput: String,
    val exampleOutput: String,
    val starterCode: String,
    val solutionCode: String,
    val hints: List<String>, // Hint 1 -> Hint 2 -> Hint 3
    val testCases: List<TestCase>
)

data class TestCase(
    val input: String,
    val expectedOutput: String,
    val description: String = ""
)

data class ExecutionResult(
    val isSuccess: Boolean,
    val output: String,
    val error: String? = null,
    val executionTimeMs: Long = 45,
    val passedTestCount: Int = 0,
    val totalTestCount: Int = 0
)

data class ProjectItem(
    val id: String,
    val courseId: String,
    val title: String,
    val iconEmoji: String = "📁",
    val level: CourseLevel,
    val description: String,
    val requirements: List<String> = emptyList(),
    val learningObjectives: List<String> = emptyList(),
    val starterSkeleton: String = "",
    val starterCode: String = "",
    val solutionCode: String = "",
    val xpReward: Int = 100
)

data class AchievementItem(
    val id: String,
    val title: String,
    val description: String,
    val iconEmoji: String,
    val xpReward: Int,
    val isUnlocked: Boolean = false,
    val unlockedAt: Long? = null
)

data class UserDailyGoal(
    val targetLessons: Int = 2,
    val completedLessons: Int = 0,
    val targetQuestions: Int = 10,
    val solvedQuestions: Int = 0,
    val targetCodingChallenges: Int = 1,
    val solvedChallenges: Int = 0,
    val targetStudyMinutes: Int = 20,
    val spentStudyMinutes: Int = 12,
    val isBonusClaimed: Boolean = false
)

data class UserProfileData(
    val username: String = "Geliştirici",
    val level: Int = 1,
    val levelTitle: String = "Çaylak (Learner)",
    val currentXp: Int = 240,
    val xpForNextLevel: Int = 500,
    val streakDays: Int = 7,
    val isPremium: Boolean = false,
    val totalStudyMinutes: Int = 145,
    val totalCompletedLessons: Int = 8,
    val totalSolvedQuizzes: Int = 24,
    val quizAccuracyPercentage: Int = 85,
    val codingSuccessPercentage: Int = 90
)

data class CourseProgressInfo(
    val courseId: String,
    val completedLessonsCount: Int,
    val totalLessonsCount: Int,
    val progressPercentage: Float,
    val lastCompletedLessonTitle: String? = null,
    val nextLessonId: String? = null
)
