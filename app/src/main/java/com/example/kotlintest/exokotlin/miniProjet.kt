package com.example.kotlintest

import com.example.kotlintest.exokotlin.RequestUtils

fun main() {
    print("Enter city: ")
    val city = readLine()!!
    val res = RequestUtils.loadWeather(city)
    val result = "Il fait " + res.temperature.temp + "° à " + city + " avec un vent de " + res.wind.speed + " km/h"
    println(result)
}