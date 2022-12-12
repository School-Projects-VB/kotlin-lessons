package com.example.kotlintest

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.kotlintest.databinding.ActivityWeatherBinding
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.concurrent.thread

class WeatherActivity : AppCompatActivity(), View.OnClickListener {
    private val binding by lazy { ActivityWeatherBinding.inflate(layoutInflater) }
    private val model by lazy { ViewModelProvider(this)[WeatherViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btLoad.setOnClickListener(this)
        binding.ivClear.setOnClickListener(this)
        binding.ivFire.setColorFilter(Color.RED)
        binding.ivFlag.setColorFilter(Color.BLUE)

        disableAll()
        if (model.data != null) {
            refreshScreen(model)
        }
    }

    override fun onClick(view: View) {
        when (view) {
            binding.ivClear -> {
                disableAll()
                binding.etCity.setText("")
            }
            binding.btLoad -> {
                binding.progressBar.isVisible = true
                thread {
                    val city = binding.etCity.text
                    model.loadData(city)
                    runOnUiThread {
                        binding.progressBar.isVisible = false
                        refreshScreen(model)
                    }
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun refreshScreen(wmodel: WeatherViewModel) {
        if (wmodel.data == null) {
            disableAll()
            binding.tvError.isVisible = true
            binding.tvError.setText(R.string.errorNotFound)
        } else {
            val weather: WeatherBean = wmodel.data!!

            binding.tvError.isVisible = false
            val icon = weather.data[0].icon
            val url = "https://openweathermap.org/img/wn/%s.png"

            binding.tvCity.text = weather.name
            binding.tvState.text = weather.data[0].description.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
            }
            binding.tvTemp.text = "${weather.temperature.temp}°"
            binding.tvDetails.text =
                "( ${weather.temperature.temp_min}° / ${weather.temperature.temp_max}° )"
            binding.tvWind.text = "${weather.wind.speed}"

            enable(binding.tvCity)
            enable(binding.tvState)
            enable(binding.tvTemp)
            enable(binding.tvDetails)
            enable(binding.tvWind)

            binding.ivClear.isVisible = true
            binding.ivFire.isVisible = true
            binding.ivFlag.isVisible = true

            thread {
                val picasso = Picasso.get().load(url.format(icon))
                runOnUiThread {
                    binding.ivWeather.isVisible = true
                    picasso.into(binding.ivWeather)
                }
            }
        }
    }

    private fun enable(element: TextView) {
        element.isVisible = true
    }

    private fun disableAll() {
        val elementsToClear = arrayListOf(
            binding.progressBar,
            binding.tvError,
            binding.ivWeather,
            binding.tvError,
            binding.tvCity,
            binding.tvTemp,
            binding.tvDetails,
            binding.tvWind,
            binding.tvState,
            binding.ivClear,
            binding.ivFire,
            binding.ivFlag
        )

        for (element in elementsToClear) {
            element.isVisible = false
        }
    }
}