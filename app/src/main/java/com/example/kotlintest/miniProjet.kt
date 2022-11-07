package com.example.kotlintest

fun main() {
    val res = RequestUtils.sendGet("https://www.google.fr")
    println("res=$res")
}