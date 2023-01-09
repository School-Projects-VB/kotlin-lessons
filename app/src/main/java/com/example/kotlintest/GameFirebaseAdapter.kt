package com.example.kotlintest

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintest.databinding.RowGameBinding
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions

class GameFirebaseAdapter(options: FirestoreRecyclerOptions<MatchBean>)
    :FirestoreRecyclerAdapter<MatchBean, GameFirebaseAdapter.ViewHolder>(options) {

    class ViewHolder(val binding: RowGameBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(RowGameBinding.inflate(LayoutInflater.from(parent.context)))

    override fun onBindViewHolder(holder: ViewHolder, position: Int, model: MatchBean) {
        println("id du document : ${snapshots.getSnapshot(position).id}")
        holder.binding.tvT1.text = model.nameTeam1
        holder.binding.tvT2.text = model.nameTeam2
    }
}