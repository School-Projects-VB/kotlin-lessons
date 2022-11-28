package com.example.kotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlintest.databinding.ActivityWeatherBinding

class WeatherActivity : AppCompatActivity() {
    private val binding by lazy { ActivityWeatherBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}