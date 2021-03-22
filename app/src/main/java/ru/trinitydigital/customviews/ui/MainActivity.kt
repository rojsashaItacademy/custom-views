package ru.trinitydigital.customviews.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.trinitydigital.customviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    val list = arrayListOf<ButtonsData>().apply {
        add(ButtonsData(title = "first", selected = true))
        add(ButtonsData(title = "second", selected = false))
    }

    val adapter = ButtonsAdapter() { selected, lastSelected ->
        updateAdapter(selected, lastSelected)
    }

    fun updateAdapter(selected: Int, lastSelected: Int) {
        if (lastSelected >= 0) {
            list[lastSelected].selected = false
            adapter.notifyItemChanged(lastSelected)
        }
        list[selected].selected = true
        adapter.notifyItemChanged(selected)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
        setupListeners()
    }

    private fun setupListeners() {
        binding.hide.setOnClickListener {
            binding.mainViews.visibility = View.GONE

        }

        binding.show.setOnClickListener {
            binding.mainViews.visibility = View.VISIBLE

        }
    }

    private fun setupViews() {
        binding.recycler.adapter = adapter
        adapter.update(list)

        val data = ResultData(title = "Offsides", firstRes = "2", secondRes = "5")
        binding.shooting.setupViews(data)


    }
}