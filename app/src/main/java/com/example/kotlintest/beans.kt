package com.example.kotlintest

import java.util.Random

fun main() {
    val car1 = CarBean("Seat", "Model", "grise")
    val car2 = CarBean2("Seat", "Model", "grise")
    println(car1)
    println(car2)

    val eleve = StudentBean("Jean")
    eleve.note = 12

    println("Eleve : nom=${eleve.nom}, note=${eleve.note}")

    val printRandomIntBean = PrintRandomIntBean(15)
    println("-----------")
    val printRandomIntBean2 = PrintRandomIntBean()

    val user = UserBean("toto")
    val user2 = UserBean("toto", 12)

    println(user)
    println(user.id)
    println(user2)
    println(user2.id)
}

data class CarBean(var marque: String, var model: String, var couleur: String)

class CarBean2(marque: String, model: String, couleur: String) {
    private var marque: String? = marque
    private var model: String? = model
    private var couleur: String? = couleur

    override fun toString(): String {
        return "CarBean2(marque=${this.marque}, model=${this.model}, couleur=${this.couleur})"
    }
}

data class StudentBean(val nom: String) {
    var note: Int = 0
}

data class PrintRandomIntBean(private val max: Int){
    private val random: Random = Random()
    init {
        printNumbers(3)
    }
    constructor() : this(100) {
        printNumbers(1)
    }

    private fun printNumbers(times: Int) {
        for (i in 1..times) {
            println(random.nextInt(max))
        }
    }
}

data class UserBean(val nom: String, var note: Int = 0) {
    val id: Int = nom.hashCode()
}
