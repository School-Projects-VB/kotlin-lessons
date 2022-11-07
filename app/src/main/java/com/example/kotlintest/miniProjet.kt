package com.example.kotlintest

fun main() {
    print("Enter city: ")
    val city = readLine()!!
    var res = RequestUtils.loadWeather(city)
    var result = "Il fait " + res.temperature.temp + "° à " + city + " avec un vent de " + res.wind.speed + " km/h"
    println(result)
}