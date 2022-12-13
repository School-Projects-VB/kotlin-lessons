package com.example.kotlintest

import android.location.Location
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.concurrent.thread

class WeatherViewModel() :
    ViewModel() {

    val weather = MutableLiveData<WeatherBean?>()
    val errorMessage = MutableLiveData<String?>()
    var runInProgress = MutableLiveData(false)

    fun loadData(location: Location?) {
        weather.postValue(null)
        errorMessage.postValue(null)
        runInProgress.postValue(true)

        thread {
            try {
                if(location == null) {
                    throw Exception("No location")
                }
                val data = RequestUtils.loadWeather(location.latitude, location.longitude)
                weather.postValue(data)
            } catch (e: java.lang.Exception) {
                val data = "[ERROR] ${e.message}"
                errorMessage.postValue(data)
                e.printStackTrace()
            }
            runInProgress.postValue(false)
        }
    }
}