package com.fouad.alfouad.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fouad.alfouad.Model.hospital.Doctor
import com.fouad.alfouad.Response
import com.fouad.alfouad.databinding.ItemNameBinding

@Suppress("DEPRECATION")
class HospitalDetailsAdapter(private val hospital_list: List<Doctor>): RecyclerView.Adapter<HospitalDetailsAdapter.HospitalViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalViewHolder {
        return HospitalViewHolder(
            ItemNameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }
    override fun onBindViewHolder(holder: HospitalViewHolder, position: Int) {
        holder.bind(hospital_list[position])

    }
    override fun getItemCount(): Int {
        return hospital_list.size
    }

    inner class HospitalViewHolder(val binding: ItemNameBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(hospitalDetails: Doctor){
//            val index =position+1
            binding.idName.text=hospitalDetails.name
            binding.position.text=hospitalDetails.price_interview
        }
    }
}