package com.example.cats_and_mice

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LevelsFragmentTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testLevelsListDisplayed() {
        // Проверяем, что заголовок отображается
        Espresso.onView(ViewMatchers.withText("Выберите уровень сложности"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        // Проверяем, что уровни отображаются в списке
        Espresso.onView(ViewMatchers.withText("Лесная опушка"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withText("Легкий"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}