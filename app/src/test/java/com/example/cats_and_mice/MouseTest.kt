package com.example.cats_and_mice

import org.junit.Test
import org.junit.Assert.*

class MouseTest {

    @Test
    fun testGetMouseInfo() {
        // Тест с заданными параметрами
        val mouse = Mouse("Джерри", 10)
        val expected = "Мышь по имени Джерри бежит со скоростью 10"
        assertEquals(expected, mouse.getMouseInfo())
    }

    @Test
    fun testGetMouseInfoWithDefaultValues() {
        // Тест с значениями по умолчанию
        val mouse = Mouse()
        val expected = "Мышь по имени  бежит со скоростью 0"
        assertEquals(expected, mouse.getMouseInfo())
    }

    @Test
    fun testGetMouseInfoWithEmptyName() {
        // Тест с пустым именем
        val mouse = Mouse("", 5)
        val expected = "Мышь по имени  бежит со скоростью 5"
        assertEquals(expected, mouse.getMouseInfo())
    }
}