package com.example.kotlintest

fun main() {
    println(replaceBy_("   te st   "))
}

// 1 - Return string without 'e' letter
fun getWithoutE(sentence :String) :String {
    var result = ""
    for (letter in sentence) {
        if (letter !in arrayOf('e', 'E')) {
            result += letter
        }
    }
    return result
}

// 2 - Return the count of 'a' letter
fun countOfA(sentence: String) :Int {
    var counter = 0
    for (letter in sentence) {
        if (letter in arrayOf('a', 'A')) {
            counter++
        }
    }
    return counter
}

// 3 - Return reverse string
fun reverseSentence(sentence :String) :String{
    var result = ""
    for (index in sentence.length - 1 downTo 0) {
        result += sentence[index]
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

// 5 - Return string without vowels
fun getWithoutVowels(sentence :String) :String{
    val vowels = "aeiouy"
    var result = ""
    for (letter in sentence) {
        if (letter !in vowels) {
            result += letter
        }
    }
    return result
}

// 6 - Return string without caps
fun getWithoutCaps(sentence :String) :String{
    var result = ""
    for (letter in sentence) {
        if (letter !in 'A'..'Z') {
            result += letter
        }
    }
    return result
}

// 7 - Return tallest char in string
fun getUppestChar(sentence: String) :Char{
    var result = 'a'
    for (letter in sentence) {
        if (letter > result) {
            result = letter
        }
    }
    return result
}

// 8a - Return string without first started space
fun getWithoutFirstStartedSpace(sentence :String) :String{
    var result = sentence
    if (sentence[0] == ' ') {
        result = sentence.substring(1)
    }
    return result
}

// 8b - Return string without started spaces (while)
fun getWithoutStartedSpaces(sentence :String) :String{
    var index = 0
    var start = 0
    while (sentence[index] == ' ') {
        index ++
        start = index
    }
    return sentence.substring(start)
}

// 8c - Return string without started spaces (for)
fun getWithoutStartedSpaces2(sentence :String) :String{
    var start_write = false
    var result = ""
    for (letter in sentence) {
        if (letter != ' ') {
            start_write = true
        }

        if (start_write) {
            result += letter
        }
    }
    println("result : ")
    return result
}

// 9 - Replace spaces by underscores
fun replaceBy_(sentence: String): String {
    var result = ""
    for (index in sentence.indices) {
        result += if(sentence[index] == ' ') '_' else sentence[index]
    }
    return result
}