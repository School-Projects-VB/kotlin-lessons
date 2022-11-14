package com.example.kotlintest

fun main() {
    exo2()
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

    var User1 = UserBean("Albert", 12)
    var User2 = UserBean("Michel", 16)
    var User3 = UserBean("Jean", 14)

    val u1 = UserBean("Bob", 19)
    val u2 = UserBean("Toto", 45)
    val u3 = UserBean("Charles", 26)

    println(compareUsersByNote(User1, User2))
    println(compareUsersByName(User1, User2))
}