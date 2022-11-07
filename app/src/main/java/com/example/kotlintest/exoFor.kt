package com.example.kotlintest

fun main() {
    println(reverseSentence("ceci est un test"))
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

// Return reverse string
fun reverseSentence(sentence :String) :String{
    var result = ""
    for (i in sentence.length - 1 downTo 0) {
        result += sentence[i]
    }
    return result
}
