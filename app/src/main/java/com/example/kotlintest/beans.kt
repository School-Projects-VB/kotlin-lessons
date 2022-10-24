package com.example.kotlintest

data class CarBean(var marque: String, var model: String, var couleur: String)

class CarBean2(marque: String, model: String, couleur: String) {
    var marque: String? = marque
    var model: String? = model
    var couleur: String? = couleur

    override fun toString(): String {
        return "CarBean2(marque=${this.marque}, model=${this.model}, couleur=${this.couleur})"
    }
}