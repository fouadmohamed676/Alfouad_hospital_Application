package com.fouad.alfouad.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.fouad.alfouad.DoctorHospital
import com.fouad.alfouad.databinding.DoctorsItemBinding

class DoctorAdapter(private val context: Context, private val dataList: List<DoctorHospital>) :
    RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        return DoctorViewHolder(
            DoctorsItemBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        val data = dataList[position]
        return holder.bind(data)

    }

    override fun getItemCount() = dataList.size

    inner class DoctorViewHolder(binding: DoctorsItemBinding) : ViewHolder(binding.root) {

        fun bind(response: DoctorHospital) {
            Log.e("response Adapter ", "$response")
//            itemView.apply{
//                binding.idName.text=response.dis
//                binding.spizilition.text=response.
//                notifyDataSetChanged()
//            }
//            Log.e("data List Doctor","$response")
        }

    }
}