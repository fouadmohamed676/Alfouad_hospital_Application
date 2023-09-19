package com.fouad.alfouad.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fouad.alfouad.Hospital
import com.fouad.alfouad.databinding.HospitalItemBinding

class HospitalAdapter(private val hospital_list: List<Hospital>):RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder>(){


    inner class HospitalViewHolder(val binding:HospitalItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(hospital_data : Hospital){

            binding.listItem = hospital_data

        }
    }


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





//            binding.listItem=hospital_data
//            itemView.apply {
//                binding.nameHospital.text = hospital.name
//                binding.title.text = hospital.title
//                binding.splize.text = hospital.spi
//            }
}