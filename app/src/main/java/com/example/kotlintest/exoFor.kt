package com.example.kotlintest

import android.view.WindowId.FocusObserver

fun main() {
    println(getWithoutE("ceci est un test"))
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