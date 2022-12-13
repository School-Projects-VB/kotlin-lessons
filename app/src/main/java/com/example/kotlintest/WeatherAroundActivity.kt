package com.example.kotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.kotlintest.databinding.ActivityWeatherAroundBinding

class WeatherAroundActivity : AppCompatActivity(), View.OnClickListener {
    private val binding by lazy { ActivityWeatherAroundBinding.inflate(layoutInflater) }
    private val model by lazy { ViewModelProvider(this)[WeatherAroundViewModel::class.java] }

    private var count = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btAdd.setOnClickListener(this)
        binding.btDelete.setOnClickListener(this)
    }

    private fun refreshScreen() {
        var texte = ""

        for(coord in model.data) {
            texte += "${coord.lon}, ${coord.lat}\n"
        }

        texte =  model.data.joinToString("\n") { "${it.lon}, ${it.lat}"  }

        binding.tv.text = texte
    }

    override fun onClick(view: View) {
        when(view) {
            binding.btAdd -> {
                model.data.add(CoordBean(count++, count++))
                refreshScreen()
            }
            binding.btDelete -> {
                model.data.removeFirstOrNull()
                refreshScreen()
            }
        }
    }
}