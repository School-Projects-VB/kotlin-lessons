package com.example.kotlintest

import com.google.gson.annotations.SerializedName
import java.util.Random

fun main() {
    val randomName = RandomName()
    randomName.add("Gérard")
    repeat(10) {
        println(randomName.next() + " ")
    }
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

data class PlaneBean(val name: String) {
    var id = name.hashCode()
    private set

    var nom = name
    set(value) {
       field = value
       id = field.hashCode()
    }
}

class TownBean(val city: String, val cp: String) {
    var country: String? = null
}
data class DataTownBean(val city: String, val cp: String) {
    var country: String? = null
}

data class CoordBean (
    var lon :Double,
    var lat :Double
)
data class WindBean (
    var speed :Double,
    var deg: Int
)
data class TempBean (
    var temp :Double,
    var feels_like :Double,
    var temp_min :Double,
    var temp_max :Double
)
data class WeatherDetailsBean (
    var main :String,
    var description :String,
    var icon: String
)
data class WeatherBean (
    var coord :CoordBean,
    var visibility :Int,
    var wind :WindBean,
    var name :String,

    @SerializedName("main")
    var temperature :TempBean,

    @SerializedName("weather")
    var data :List<WeatherDetailsBean>
)

class RandomName {
    private val random: Random = Random()
    private var names :ArrayList<String> = arrayListOf("Benjamin", "Mathilde", "Jérémy")

    fun add(name :String) {
        if (name.isBlank() || name.contains(' ') || name in names) {
            throw Exception("Impossible d'ajouter ce prénom")
        } else {
            names.add(name)
            println("Nom ajouté")
        }
    }
    
    fun next() :String{return names[random.nextInt(names.size)]}
}
