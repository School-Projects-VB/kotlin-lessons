package com.example.kotlintest

fun main() {
    println("C’est chiant à lire".kids())
    println(16.sqrt())
}

fun String.kids() :String {
    var result = ""
    for (index in this.indices) {
        if (index % 2 == 0) {
            result += this[index].uppercaseChar()
        } else {
            result += this[index].lowercaseChar()
        }
    }
    return result
}

fun Int.sqrt() :Int {
    var result = 0
    for (index in 1..this / 2) {
        if (index * index == this) {
            result = index
        }
    }
    return result
}