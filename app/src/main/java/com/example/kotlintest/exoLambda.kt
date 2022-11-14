package com.example.kotlintest

fun main() {
    exo1()
}

fun exo1() {
    val Lower = { text:String -> println(text.lowercase()) }
    Lower("TeSt TEST")

    val Heure: (Int) -> Int = { it/60 }
    println(Heure(142))

    val Max = { a: Int, b: Int -> if(a > b) a else b }
    println(Max(3,5))

    val Reverse: (String) -> String = { it.reversed() }
    println(Reverse("toto test"))

    val minToMinHour: (Int) -> Pair<Int, Int> = { it/60 to it %60 }
    println(minToMinHour(142))
}