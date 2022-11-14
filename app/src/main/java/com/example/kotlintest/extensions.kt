package com.example.kotlintest

fun main() {
    println("C’est chiant à lire".kids())
    println(16.sqrt())
}

fun String.kids() :String{
    var result = ""

    for ((index, char) in this.withIndex()) {
        result += if (index % 2 == 0) char.uppercaseChar() else char.lowercaseChar()
    }

    return result
}

fun Number.sqrt() = kotlin.math.sqrt(this.toDouble())