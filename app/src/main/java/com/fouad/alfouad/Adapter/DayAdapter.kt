package com.fouad.alfouad.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.fouad.alfouad.Time
import com.fouad.alfouad.databinding.DayItemBinding

class DayAdapter(private val context: Context, private val dataList: List<Time>) :
    RecyclerView.Adapter<DayAdapter.DayViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        return DayViewHolder(DayItemBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        val data = dataList[position]
        return holder.bind(data)
    }

    override fun getItemCount() = dataList.size

    inner class DayViewHolder(private val binding: DayItemBinding) : ViewHolder(binding.root) {
        fun bind(day: Time) {
            Log.e("day response Adapter ", "$day")
            binding.listItem = day
        }

    }

}