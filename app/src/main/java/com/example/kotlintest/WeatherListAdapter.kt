package com.example.kotlintest

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintest.databinding.RowWeatherBinding

class WeatherListAdapter :ListAdapter<CoordBean, WeatherListAdapter.ViewHolder>(Comparator()) {
    class ViewHolder(var binding :RowWeatherBinding) : RecyclerView.ViewHolder(binding.root)

    class Comparator : DiffUtil.ItemCallback<CoordBean>() {
        override fun areItemsTheSame(oldItem: CoordBean, newItem: CoordBean): Boolean
            = oldItem === newItem

        override fun areContentsTheSame(oldItem: CoordBean, newItem: CoordBean): Boolean
            = oldItem.lon == newItem.lon && oldItem.lat == newItem.lat
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(RowWeatherBinding.inflate(LayoutInflater.from(parent.context)))

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = getItem(position)
        holder.binding.tvCity.text = "${current.lat}, ${current.lon} "
        holder.binding.tvTemp.text = "Toulouse"
    }
}