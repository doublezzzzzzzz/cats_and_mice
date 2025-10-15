package com.example.cats_and_mice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.startButton)
        val settingsButton = findViewById<Button>(R.id.settingsButton)

        startButton.setOnClickListener {
            // Показываем всплывающее уведомление
            Toast.makeText(this, "Игра начинается!", Toast.LENGTH_SHORT).show()

            // Переходим к выбору уровней
            supportFragmentManager.commit {
                replace(R.id.fragment_container, LevelsFragment())
                addToBackStack("levels")
            }
        }

        settingsButton.setOnClickListener {
            supportFragmentManager.commit {
                replace(R.id.fragment_container, SettingsFragment())
                addToBackStack("settings")
            }
        }
    }
}