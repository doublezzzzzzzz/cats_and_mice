package com.example.cats_and_mice

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class SharedViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: SharedViewModel

    @Before
    fun setup() {
        viewModel = SharedViewModel()
    }

    @Test
    fun testSelectLevel() {
        val testLevel = Level(1, "Тестовый уровень", "Легкий")

        viewModel.selectLevel(testLevel)

        assertEquals(testLevel, viewModel.selectedLevel.value)
    }

    @Test
    fun testInitialSelectedLevelIsNull() {
        assertNull(viewModel.selectedLevel.value)
    }

    @Test
    fun testMultipleLevelSelections() {
        val level1 = Level(1, "Уровень 1", "Легкий")
        val level2 = Level(2, "Уровень 2", "Сложный")

        viewModel.selectLevel(level1)
        assertEquals(level1, viewModel.selectedLevel.value)

        viewModel.selectLevel(level2)
        assertEquals(level2, viewModel.selectedLevel.value)
    }
}