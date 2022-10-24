package com.example.kotlintest

fun main() {
    val car1 = CarBean("Seat", "Leon", "grise")
    val car2 = CarBean2("Seat", "Leon", "grise")
    println(car1.toString())
    println(car2.toString())
}

// min
fun min(a:Int, b:Int, c:Int) :Int = if (a < b && a < c) a else if (b < a && b < c) b else c

// pair
fun pair(number: Int): Boolean = number % 2 == 0

// myPrint
fun myPrint(str: String): String = "#$str#"

// Quel est le type de retour de myPrint ?
// String

fun boulangerie(croissants: Int = 0, baguettes: Int = 0, sandwichs: Int = 0): Double = (croissants*PRIX_CROISSANT + baguettes*PRIX_BAGUETTE + sandwichs*PRIX_SANDWICH)