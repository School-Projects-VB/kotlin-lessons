package com.example.kotlintest

fun main() {
    exo1()
}

fun exo1() {
    val Lower: (String) -> Unit = { println(it.lowercase()) }
    Lower("TeSt TEST")

    val Heure: (Int) -> Int = { it/60 }
    println(Heure(142))

    val Max: (Int, Int) -> Int = { a: Int, b: Int -> if(a > b) a else b }
    println(Max(3,5))

    val Reverse: (String) -> String = { it.reversed() }
    println(Reverse("toto test"))
}