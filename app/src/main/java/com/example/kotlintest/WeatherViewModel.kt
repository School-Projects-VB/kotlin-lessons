package com.example.kotlintest

import android.text.Editable
import androidx.lifecycle.ViewModel
import com.example.kotlintest.exokotlin.RequestUtils


class WeatherViewModel(var weather: WeatherBean? = null, var errorMessage: String? = null) :
    ViewModel() {
    fun loadData(city: Editable) {
        weather = null
        errorMessage = null
        try {
            weather = RequestUtils.loadWeather(city)
        } catch (e: java.lang.Exception) {
            errorMessage = "[ERROR] ${e.message}"
            e.printStackTrace()
        }
    }
}