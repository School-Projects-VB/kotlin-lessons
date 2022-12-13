package com.example.kotlintest

import androidx.lifecycle.ViewModel

class WeatherAroundViewModel() :
    ViewModel() {
    val data = ArrayList<CoordBean>()
}