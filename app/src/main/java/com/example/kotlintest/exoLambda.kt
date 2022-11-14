package com.example.kotlintest

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

fun exo4() {
    val users = arrayListOf(
        UserBean ("toto", 16),
        UserBean ("Bobby", 20),
        UserBean ("Charles", 14)
    )

    println(users.sortedBy { it.nom })
    println(users.filter { it.note >= 10 })
    println(users.count { it.nom == "toto" })
    println(users.filter { it.note >= 10 }.count { it.nom == "toto" })

    val average = users.map{ it.note }.average()
    println(average)
    println(users.filter { it.note > average })

    val list6 = users
    list6.filter { it.note < 10 }.forEach { it.note++ }
    println(list6)

    val list7 = users
    list7.filter { it.nom.equals("toto", true)}.forEach { it.note++ }
    println(list7)

    val list8 = users
    println(list8.filter { it.note > list8.map { it.note }.min() })

    println(users.filter { it.note >= 10 }.sortedBy { it.nom }.joinToString { "${it.nom}, " })
}