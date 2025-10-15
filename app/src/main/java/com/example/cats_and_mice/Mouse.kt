package com.example.cats_and_mice

class Mouse(
    private val name: String = "",
    private val speed: Int = 0
) {
    fun getMouseInfo(): String {
        return "Мышь по имени $name бежит со скоростью $speed"
    }
}