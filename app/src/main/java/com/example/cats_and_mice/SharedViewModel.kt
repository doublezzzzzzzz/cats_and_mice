package com.example.cats_and_mice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _selectedLevel = MutableLiveData<Level?>()
    val selectedLevel: LiveData<Level?> = _selectedLevel

    fun selectLevel(level: Level) {
        _selectedLevel.value = level
    }
}