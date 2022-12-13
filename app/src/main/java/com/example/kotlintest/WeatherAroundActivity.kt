package com.example.kotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlintest.databinding.ActivityWeatherAroundBinding

class WeatherAroundActivity : AppCompatActivity(), View.OnClickListener {
    private val binding by lazy { ActivityWeatherAroundBinding.inflate(layoutInflater) }
    private val model by lazy { ViewModelProvider(this)[WeatherAroundViewModel::class.java] }
    private val adapter = WeatherListAdapter()

    private var count = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btAdd.setOnClickListener(this)
        binding.btDelete.setOnClickListener(this)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(this, 1)
    }

    override fun onClick(view: View) {
        when(view) {
            binding.btAdd -> {
                model.data.add(CoordBean(count++, count++))
                adapter.submitList(model.data.toList())
            }
            binding.btDelete -> {
                model.data.removeFirstOrNull()
                adapter.submitList(model.data.toList())
            }
        }
    }
}