package com.example.kotlintest

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


private const val TABLE_NAME = "matches"
object MatchFirebaseRepo {
    private fun getCollection()= Firebase.firestore.collection(TABLE_NAME)
    fun create(data: MatchBean) = getCollection().add(data)
}