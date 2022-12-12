package com.example.kotlintest

import android.text.Editable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlintest.exokotlin.RequestUtils


class WeatherViewModel() :
    ViewModel() {

    val weather = MutableLiveData<WeatherBean?>()
    val errorMessage = MutableLiveData<String?>()

    fun loadData(city: Editable) {
        try {
            val data = RequestUtils.loadWeather(city)
            weather.postValue(data)
        } catch (e: java.lang.Exception) {
            val data = "[ERROR] ${e.message}"
            errorMessage.postValue(data)
            e.printStackTrace()
        }
    }
}