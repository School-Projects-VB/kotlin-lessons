package com.example.kotlintest

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.kotlintest.databinding.ActivityWeatherBinding
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.collections.ArrayList

class WeatherActivity : AppCompatActivity(), View.OnClickListener {
    private val binding by lazy { ActivityWeatherBinding.inflate(layoutInflater) }
    private val model by lazy { ViewModelProvider(this)[WeatherViewModel::class.java] }
    private var tvToDisplay = ArrayList<TextView>()
    private var ivToDisplay = ArrayList<ImageView>()
    private val elementLists = arrayOf(tvToDisplay, ivToDisplay)


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        this.tvToDisplay.addAll(
            arrayOf(
                binding.tvError,
                binding.tvCity,
                binding.tvTemp,
                binding.tvDetails,
                binding.tvWind,
                binding.tvState
            )
        )
        this.ivToDisplay.addAll(
            arrayOf(
                binding.ivWeather,
                binding.ivClear,
                binding.ivFire,
                binding.ivFlag
            )
        )

        binding.btLoad.setOnClickListener(this)
        binding.ivClear.setOnClickListener(this)
        binding.ivFire.setColorFilter(Color.RED)
        binding.ivFlag.setColorFilter(Color.BLUE)

        disableAll()

        model.errorMessage.observe(this) {
            enable(binding.tvError)
            binding.tvError.setText(R.string.errorNotFound)
        }

        model.weather.observe(this) { weather ->
            enableAll()
            disable(binding.tvError)

            binding.tvCity.text = weather?.name
            binding.tvState.text = weather?.data?.get(0)?.description?.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
            }
            binding.tvTemp.text = "${weather?.temperature?.temp}°"
            binding.tvDetails.text =
                "( ${weather?.temperature?.temp_min}° / ${weather?.temperature?.temp_max}° )"
            binding.tvWind.text = "${weather?.wind?.speed} km/h"

            println("https://openweathermap.org/img/wn/%s.png".format(weather?.data?.get(0)?.icon))
            Picasso.get().load("https://openweathermap.org/img/wn/%s.png".format(weather?.data?.get(0)?.icon)).into(binding.ivWeather)
        }

        model.runInProgress.observe(this) {
            binding.progressBar.isVisible = it
        }
    }

    override fun onClick(view: View) {
        when (view) {
            binding.ivClear -> {
                disableAll()
            }
            binding.btLoad -> {
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                    showWeather()
                } else {
                    ActivityCompat.requestPermissions(this,
                        arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 0)
                }
            }
        }
    }

    private fun disableAll() {
        this.elementLists.forEach { list ->
            for (element in list) {
                element.isVisible = false
            }
        }
    }

    private fun enableAll() {
        this.elementLists.forEach { list ->
            for (element in list) {
                element.isVisible = true
            }
        }
    }

    private fun enable(element: TextView) {
        element.isVisible = true
    }

    private fun disable(element: TextView) {
        element.isVisible = false
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED) {
            showWeather()
        } else {
            Toast.makeText(this, "Need permission location", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showWeather() {
        model.loadData(LocationUtils.getLastKnownLocation(this))
    }
}
