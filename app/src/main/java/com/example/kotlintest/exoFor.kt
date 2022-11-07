package com.example.kotlintest

import android.view.WindowId.FocusObserver
import androidx.core.provider.FontRequest

fun main() {
    println(countOfA("analphabet"))
}

// Return string without 'e' letter
fun getWithoutE(sentence :String) :String {
    var result :String = ""
    for (i in sentence.indices) {
        val letter = sentence[i]
        if (letter != 'e') {
            result += letter
        }
    }
    return result
}

// Return the count of 'a' letter
fun countOfA(sentence: String) :Int {
    var counter :Int = 0
    for (i in sentence.indices) {
        if (sentence[i] == 'a') {
            counter++
        }
    }
    return counter
}

