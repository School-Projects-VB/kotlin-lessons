package com.example.kotlintest

import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    exo1()
    exo2()
    exo4()
}

inline fun compareUser(compare: (UserBean, UserBean) -> UserBean, u1: UserBean, vararg list: UserBean): UserBean {
    var selectUser = u1
    for (u in list) {
        selectUser = compare(u, selectUser)
    }
    return selectUser
}

fun Iterable<UserBean>.print()= println(this.joinToString("\n") { it.nom + " : " + it.note })

fun exo1() {
    val Lower = { text:String -> println(text.lowercase()) }
    Lower("TeSt TEST")

    val Heure: (Int) -> Int = { it/60 }
    println(Heure(142))

    val Max = { a: Int, b: Int -> if(a > b) a else b }
    println(Max(3,5))

    val Reverse: (String) -> String = { it.reversed() }
    println(Reverse("toto test"))

    val minToMinHour: (Int) -> Pair<Int, Int> = { it/60 to it %60 }
    println(minToMinHour(142))
}

fun exo2() {
    val compareUsersByNote = { A: UserBean, B: UserBean -> if(A.note >= B.note) A else B }
    val compareUsersByName = { A: UserBean, B: UserBean -> if(A.nom <= B.nom) A else B }

    val u1 = UserBean("Bob", 19)
    val u2 = UserBean("Toto", 45)
    val u3 = UserBean("Charles", 26)

    println(compareUser(compareUsersByNote, u1, u2, u3))
    println(compareUser(compareUsersByName, u1, u2, u3))
}

@RequiresApi(Build.VERSION_CODES.N)
fun exo4() {
    val users = arrayListOf(
        UserBean ("toto", 16),
        UserBean ("Bobby", 20),
        UserBean ("Charles", 14)
    )

    users.sortedBy { it.nom.lowercase() }.print()
    users.filter { it.note >= 10 }.print()

    // println(users.count { it.nom.equals("Toto", true)})
    val listToto = { it: UserBean -> it.nom.equals("Toto", true) }
    println(users.count(listToto))

    println(users.count { listToto(it) && it.note >= 10 })

    val average = users.map{ it.note }.average()
    println(average)
    println(users.count { listToto(it) && it.note >= average })

    val list6 = users
    list6.filter { it.note < 10 }.forEach { it.note++ }
    list6.print()

    val list7 = users
    list7.filter(listToto).forEach { it.note++ }
    list7.print()

    val list8 = users
    val minNote = list8.minOfOrNull { it.note }
    list8.removeIf { it.note == minNote }

    print(users.filter { it.note >= 10 }.map { it.nom }.sortedBy { it })
}