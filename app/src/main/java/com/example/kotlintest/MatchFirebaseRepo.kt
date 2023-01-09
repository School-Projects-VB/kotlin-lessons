package com.example.kotlintest

import androidx.lifecycle.LifecycleOwner
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

private const val TABLE_NAME = "matches"

object MatchFirebaseRepo {
    private val orderByTime = getCollection().orderBy("time", Query.Direction.DESCENDING)
    private fun getCollection() = Firebase.firestore.collection(TABLE_NAME)

    fun create(data: MatchBean) = getCollection().add(data)

    fun select(activity: LifecycleOwner) = FirestoreRecyclerOptions.Builder<MatchBean>()
        .setQuery(orderByTime, MatchBean::class.java)
        .setLifecycleOwner(activity)
        .build()
}