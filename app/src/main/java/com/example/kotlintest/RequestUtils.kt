package com.example.kotlintest

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

fun main() {
    var weather = RequestUtils.loadWeather("Bordeaux")
    println(weather)
}

object RequestUtils {
    private val client = OkHttpClient()
    var gson = Gson()

    fun loadWeather(city: String): WeatherBean {
        var url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=b80967f0a6bd10d23e44848547b26550&units=metric&lang=fr"
        val json: String = sendGet(url)
        var data = gson.fromJson(json, WeatherBean::class.java)
        return data
    }

    fun sendGet(url: String): String {
        println("url : $url")
        val request = Request.Builder().url(url).build()
        return client.newCall(request).execute().use {
            if (!it.isSuccessful) {
                throw Exception("Réponse du serveur incorrect :${it.code}")
            }
            it.body.string()
        }
    }
}