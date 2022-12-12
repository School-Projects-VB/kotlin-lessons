package com.example.kotlintest

import android.text.Editable
import androidx.lifecycle.ViewModel
import com.example.kotlintest.exokotlin.RequestUtils


class WeatherViewModel(var data: WeatherBean? = null, var errorMessage: String? = null) :
    ViewModel() {
    fun loadData(city: Editable) {
        try {
            this.data = RequestUtils.loadWeather(city)
        } catch (e: java.lang.Exception) {
            this.errorMessage = e.toString()
            e.printStackTrace()
        }
    }
}