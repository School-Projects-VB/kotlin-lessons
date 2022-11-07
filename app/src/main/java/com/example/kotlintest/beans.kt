package com.example.kotlintest

import com.google.gson.annotations.SerializedName
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

    val plane = PlaneBean("Toto")
    println("${plane.nom} : ${plane.id}")
    plane.nom = "bob"
    println("${plane.nom} : ${plane.id}")

    val city = TownBean("Toulouse", "31000")
    city.country = "toto"
    val city2 = TownBean("Toulouse", "31000")
    city2.country = "toto2"

    val dataCity = DataTownBean("Toulouse", "31000")
    dataCity.country = "toto"
    val dataCity2 = DataTownBean("Toulouse", "31000")
    dataCity2.country = "toto2"

    println("city=$city") //city=TownBean@123245
    println("dataCity=$dataCity")//dataCity=DataTownBean(city=Toulouse, cp=31000)

    println("== : ${city == city2}") //== : false
    println("equals : ${city.equals(city2)}")// equals : false
    println("=== : ${city === city2}") //=== : false

    println("data == : ${dataCity == dataCity2}") // data == : true
    println("data equals : ${dataCity.equals(dataCity2)}")//data equals : true
    println("data === : ${dataCity === dataCity2}") //data === : false
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
data class WeatherBean (
    var coord :CoordBean,
    var visibility :Int,
    var wind :WindBean,
    var name :String,

    @SerializedName("main")
    var temperature:TempBean
)
