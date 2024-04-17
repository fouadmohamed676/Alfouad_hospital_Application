package com.fouad.alfouad.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.fouad.alfouad.ResponseDoctorsSp
import com.fouad.alfouad.databinding.SpicItemBinding

class SpDoctorsAdapter(private val context: Context, private val dataList: List<ResponseDoctorsSp>) :
    RecyclerView.Adapter<SpDoctorsAdapter.SpViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpViewHolder {
        return SpViewHolder(SpicItemBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: SpViewHolder, position: Int) {
        val data = dataList[position]
        return holder.bind(data)
    }

    override fun getItemCount() = dataList.size

    inner class SpViewHolder(private val binding: SpicItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(sp: ResponseDoctorsSp) {
            binding.listItem = sp
        itemView.setOnClickListener {
            Toast.makeText(itemView.context, sp.name,Toast.LENGTH_SHORT).show()
        }
        }


    }
}