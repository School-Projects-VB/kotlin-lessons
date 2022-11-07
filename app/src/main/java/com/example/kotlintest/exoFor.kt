package com.example.kotlintest

fun main() {
    println(getWithoutVowels("ceci est un test aeiouy"))
}

// 1 - Return string without 'e' letter
fun getWithoutE(sentence :String) :String {
    var result = ""
    for (letter in sentence) {
        if (letter != 'e') {
            result += letter
        }
    }
    return result
}

// 2 - Return the count of 'a' letter
fun countOfA(sentence: String) :Int {
    var counter = 0
    for (letter in sentence) {
        if (letter == 'a') {
            counter++
        }
    }
    return counter
}

// 3 - Return reverse string
fun reverseSentence(sentence :String) :String{
    var result = ""
    for (i in sentence.length - 1 downTo 0) {
        result += sentence[i]
    }
    return result
}

// 4 - Return count of caps
fun countCaps(sentence :String) :Int{
    var counter = 0
    for (letter in sentence) {
        if (letter in 'A'..'Z') {
            counter++
        }
    }
    return counter
}

// 5 - Return sentence without vowels
fun getWithoutVowels(sentence :String) :String{
    val vowels: List<Char> = listOf('a', 'e', 'i', 'o', 'u', 'y')
    var result = ""
    for (letter in sentence) {
        if (letter !in vowels) {
            result += letter
        }
    }
    return result
}