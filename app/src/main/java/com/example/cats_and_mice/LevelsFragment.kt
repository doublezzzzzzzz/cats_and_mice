package com.example.cats_and_mice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LevelsFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_levels, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val levels = listOf(
            Level(1, "Лесная опушка", "Легкий"),
            Level(2, "Городские крыши", "Средний"),
            Level(3, "Подземелье", "Сложный")
        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.levelsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = LevelsAdapter(levels) { level ->
            sharedViewModel.selectLevel(level)
            // Можно добавить навигацию назад или показ сообщения
        }
    }
}