package com.example.kotlintest

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.kotlintest.databinding.ActivityWeatherBinding
import com.example.kotlintest.exokotlin.RequestUtils
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.concurrent.thread

class WeatherActivity : AppCompatActivity(), View.OnClickListener {
    private val binding by lazy { ActivityWeatherBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        disableAll()
        binding.btLoad.setOnClickListener(this)
        binding.ivClear.setOnClickListener(this)
        binding.ivFire.setColorFilter(Color.RED)
        binding.ivFlag.setColorFilter(Color.BLUE)
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(view: View) {
        when(view) {
            binding.ivClear -> {
                disableAll()
                binding.etCity.setText("")
            }
            binding.btLoad -> {
                binding.progressBar.isVisible = true
                thread {
                    val city = binding.etCity.text
                    var weather :WeatherBean? = null
                    try {
                        weather = RequestUtils.loadWeather(city)
                    } catch (e :java.lang.Exception) {
                        println(getText(R.string.errorNotFound))
                        e.printStackTrace()
                    }
                    runOnUiThread {
                        if(weather == null) {
                            disableAll()
                            binding.tvError.isVisible = true
                            binding.tvError.setText(R.string.errorNotFound)
                        } else {
                            binding.tvError.isVisible = false
                            val icon = weather.data[0].icon
                            val url = "https://openweathermap.org/img/wn/%s.png"

                            binding.tvCity.text = weather.name
                            binding.tvState.text = weather.data[0].description.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
                            binding.tvTemp.text = "${weather.temperature.temp}°"
                            binding.tvDetails.text = "( ${weather.temperature.temp_min}° / ${weather.temperature.temp_max}° )"
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
                        binding.progressBar.isVisible = false
                    }
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