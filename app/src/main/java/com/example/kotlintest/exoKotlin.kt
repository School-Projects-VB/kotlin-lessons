package com.example.kotlintest

fun main() {
    println(boulangerie(3, 5, 2))
}

// min
fun min(a:Int, b:Int, c:Int) :Int = if (a < b && a < c) a else if (b < a && b < c) b else c

// pair
fun pair(number: Int): Boolean = number % 2 == 0

// myPrint
fun myPrint(str: String): String = "#$str#"

// Quel est le type de retour de myPrint ?
// String

fun boulangerie(croissants: Int, baguettes: Int, sandwichs: Int): Double {
    return (croissants*PRIX_CROISSANT + baguettes*PRIX_BAGUETTE + sandwichs*PRIX_SANDWICH)
}