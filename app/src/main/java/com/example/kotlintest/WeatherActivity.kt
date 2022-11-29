package com.example.kotlintest

import android.annotation.SuppressLint
import android.graphics.Color
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
        binding.ivFire.setColorFilter(Color.RED)
        binding.ivFlag.setColorFilter(Color.BLUE)
        binding.progressBar.isVisible = false
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(view: View) {
        when(view) {
            binding.btLoad -> {
                binding.progressBar.isVisible = true
                thread {
                    val city = "Toulouse"
                    val weather = RequestUtils.loadWeather(city)
                    runOnUiThread {
                        binding.progressBar.isVisible = false
                    }
                }
            }
        }
    }
}