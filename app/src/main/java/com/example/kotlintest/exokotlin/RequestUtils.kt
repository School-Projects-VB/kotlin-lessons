package com.example.kotlintest.exokotlin

import com.example.kotlintest.WeatherBean
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

const val URL_API_WEATHER =
    "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=b80967f0a6bd10d23e44848547b26550&units=metric&lang=fr"

object RequestUtils {
    private val client = OkHttpClient()
    private var gson = Gson()

    fun loadWeather(city: String): WeatherBean {
        val json: String = sendGet(URL_API_WEATHER.format(city))
        return gson.fromJson(json, WeatherBean::class.java)
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