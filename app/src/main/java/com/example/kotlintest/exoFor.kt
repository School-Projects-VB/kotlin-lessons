package com.example.kotlintest

fun main() {
    println(countOfA("mal"))
}

// Return string without 'e' letter
fun getWithoutE(sentence :String) :String {
    var result = ""
    for (letter in sentence) {
        if (letter != 'e') {
            result += letter
        }
    }
    return result
}

// Return the count of 'a' letter
fun countOfA(sentence: String) :Int {
    var counter = 0
    for (letter in sentence) {
        if (letter == 'a') {
            counter++
        }
    }
    return counter
}
