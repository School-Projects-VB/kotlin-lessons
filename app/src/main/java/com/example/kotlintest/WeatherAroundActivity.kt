package com.example.kotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.kotlintest.databinding.ActivityWeatherAroundBinding

class WeatherAroundActivity : AppCompatActivity(), View.OnClickListener {
    private val binding by lazy { ActivityWeatherAroundBinding.inflate(layoutInflater) }
    private val model by lazy { ViewModelProvider(this)[WeatherAroundViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_around)

        binding.btAdd.setOnClickListener(this)
        println("oncreate finish")
    }

    override fun onClick(view: View) {
        println("Enter")
        when (view) {
            binding.btAdd -> {
                model.data.addAll(arrayOf(
                    CoordBean(2.66, 1.52),
                    CoordBean(6.44, 6.45),
                    CoordBean(6.28, 7.25)))
                println(model.data)
                val input = "%s %s %s"
                println(input)
                val test = input.format(model.data)
                println(test)
            }
        }
    }
}