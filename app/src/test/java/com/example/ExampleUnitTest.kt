package com.example

import org.junit.Assert.*
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
  @Test
  fun addition_isCorrect() {
    assertEquals(4, 2 + 2)
  }

  @Test
  fun aiCurriculum_integrity_isCorrect() {
    val aiLanguage = com.example.data.catalog.CourseCatalog.languages.firstOrNull { it.id == "ai" }
    assertNotNull("AI course should be registered in languages", aiLanguage)
    assertEquals("Yapay Zeka (AI)", aiLanguage?.name)

    val sections = com.example.data.catalog.CourseCatalog.getSections("ai")
    assertEquals(5, sections.size)

    val lessons = com.example.data.catalog.CourseCatalog.getLessonsForCourse("ai")
    assertEquals(12, lessons.size)

    // Verify levels: Beginner, Fundamental, Intermediate, Advanced, Expert
    val levels = lessons.map { it.level }.toSet()
    assertTrue(levels.contains(com.example.model.CourseLevel.BEGINNER))
    assertTrue(levels.contains(com.example.model.CourseLevel.INTERMEDIATE))
    assertTrue(levels.contains(com.example.model.CourseLevel.ADVANCED))
    assertTrue(levels.contains(com.example.model.CourseLevel.EXPERT))

    // Verify all lessons have content, challenges, and quiz questions
    lessons.forEach { lesson ->
      assertTrue(lesson.detailedExplanation.isNotEmpty())
      assertNotNull(lesson.codingChallenge)
      assertTrue(lesson.quizQuestions.isNotEmpty())
      assertTrue(!lesson.practicalTask.isNullOrBlank())
    }
  }
}
