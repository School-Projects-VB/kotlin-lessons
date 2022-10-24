package com.example.kotlintest

fun main() {
    println(boulangerie(2))
    println(boulangerie(baguettes = 2, sandwichs = 3))
}

// boulangerie
fun boulangerie(croissants: Int = 0, baguettes: Int = 0, sandwichs: Int = 0): Double = (croissants*PRIX_CROISSANT + baguettes*PRIX_BAGUETTE + sandwichs*PRIX_SANDWICH)