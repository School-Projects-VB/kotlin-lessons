package com.example.kotlintest

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.example.kotlintest.databinding.ActivityWeatherBinding
import com.example.kotlintest.exokotlin.RequestUtils
import kotlin.concurrent.thread

class WeatherActivity : AppCompatActivity(), View.OnClickListener {
    private val binding by lazy { ActivityWeatherBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btLoad.setOnClickListener(this)
        binding.btAnnuler.setOnClickListener(this)
        binding.progressBar.isVisible = false
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(view: View) {
        when(view) {
            binding.btAnnuler -> {binding.text.text = getText(R.string.tv)}
            binding.btLoad -> {
                binding.progressBar.isVisible = true
                thread {
                    val weather = RequestUtils.loadWeather("Bordeaux")
                    runOnUiThread {
                        binding.text.text = "Il fait ${weather.temperature.temp}° à ${weather.name} avec un vent de ${weather.wind.speed} km/h"
                        binding.progressBar.isVisible = false
                    }
                }
            }
        }
    }
}