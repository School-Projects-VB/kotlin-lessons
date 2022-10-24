package com.example.kotlintest

fun main() {
    println(min(0, 3, 5))
    println(min(3, 0, 5))
    println(min(5, 3, 0))
    println(pair(1))
    println(pair(2))
    println(myPrint("foo"))
    println(boulangerie(2))
    println(boulangerie(baguettes = 2, sandwichs = 3))
}

// min
fun min(a:Int, b:Int, c:Int) :Int = if (a < b && a < c) a else if (b < a && b < c) b else c

// pair
fun pair(number: Int): Boolean = number % 2 == 0

// myPrint
fun myPrint(str: String): String = "#$str#"

// Quel est le type de retour de myPrint ?
// String

// boulangerie
fun boulangerie(croissants: Int = 0, baguettes: Int = 0, sandwichs: Int = 0): Double = (croissants*PRIX_CROISSANT + baguettes*PRIX_BAGUETTE + sandwichs*PRIX_SANDWICH)