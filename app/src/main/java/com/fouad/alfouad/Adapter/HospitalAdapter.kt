package com.fouad.alfouad.Adapter

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fouad.alfouad.Hospital
import com.fouad.alfouad.databinding.HospitalItemBinding

class HospitalAdapter(private val hospital_list: List<Hospital>):RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalViewHolder {
        return HospitalViewHolder(
            HospitalItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }
    override fun onBindViewHolder(holder: HospitalViewHolder, position: Int) {
        holder.bind(hospital_list[position])

    }
    override fun getItemCount(): Int {
       return hospital_list.size
    }


    inner class HospitalViewHolder(val binding:HospitalItemBinding) : RecyclerView.ViewHolder(binding.root){


        fun bind(hospital: Hospital){
            binding.splizeetion.text=hospital.hospitals.getString("name")
            if (hospital.status=="1"){
                binding.imgStatus.setColorFilter(Color.GREEN)
                binding.status.text="يعمل"
            }else{
                binding.imgStatus.setColorFilter(Color.RED)
                binding.status.text="لا يعمل"
            }
            binding.listItem= hospital
        }
    }


}