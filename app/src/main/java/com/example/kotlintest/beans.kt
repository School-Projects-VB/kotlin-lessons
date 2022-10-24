package com.example.kotlintest

fun main() {
    val car1 = CarBean("Seat", "Model", "grise")
    val car2 = CarBean2("Seat", "Model", "grise")
    println(car1)
    println(car2)

    val eleve = StudentBean("Jean")
    eleve.note = 12

    println("Eleve : nom=${eleve.nom}, note=${eleve.note}")
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

class StudentBean(val nom: String) {
    var note: Int = 0
}