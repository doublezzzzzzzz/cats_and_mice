package com.example.cats_and_mice

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Switch
import androidx.fragment.app.Fragment

class SettingsFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE)

        val musicSwitch = view.findViewById<Switch>(R.id.musicSwitch)
        val playerNameEditText = view.findViewById<EditText>(R.id.playerNameEditText)

        // Загрузка сохраненных настроек
        musicSwitch.isChecked = sharedPreferences.getBoolean("music_enabled", true)
        playerNameEditText.setText(sharedPreferences.getString("player_name", "Игрок"))

        // Сохранение настроек при изменении
        musicSwitch.setOnCheckedChangeListener { _, isChecked ->
            sharedPreferences.edit().putBoolean("music_enabled", isChecked).apply()
        }

        playerNameEditText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                sharedPreferences.edit()
                    .putString("player_name", playerNameEditText.text.toString())
                    .apply()
            }
        }
    }
}