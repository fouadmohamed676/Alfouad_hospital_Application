package com.fouad.alfouad.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fouad.alfouad.Model.pation.Sick
import com.fouad.alfouad.databinding.SickItemBinding

class SicksAdapter (private val context: Context, private val dataList: List<Sick>) :
    RecyclerView.Adapter<SicksAdapter.DayViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        return DayViewHolder(SickItemBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        val data = dataList[position]
        return holder.bind(data)
    }

    override fun getItemCount() = dataList.size

    inner class DayViewHolder(private val binding: SickItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(sick: Sick) {
            Log.e("day response Adapter ", "$sick")
            binding.name.text=sick.name
//            binding.listItem = sick.name
        }

    }
}