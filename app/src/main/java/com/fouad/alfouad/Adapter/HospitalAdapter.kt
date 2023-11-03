package com.fouad.alfouad.Adapter

import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fouad.alfouad.HospitalPojoO
import com.fouad.alfouad.databinding.HospitalItemBinding
import com.fouad.alfouad.ui.Services.Details.HospitalDetailsActivity

class HospitalAdapter(private val hospital_list: List<HospitalPojoO>)

    :RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalViewHolder {
        return HospitalViewHolder(
            HospitalItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }
    override fun onBindViewHolder(holder: HospitalViewHolder, position: Int) {
        holder.bind(hospital_list[position])

    }
    override fun getItemCount()=hospital_list.size

    inner class HospitalViewHolder(val binding:HospitalItemBinding) : RecyclerView.ViewHolder(binding.root){


        fun bind(hospital: HospitalPojoO){

            binding.splizeetion.text=hospital.hospitals?.name
            binding.local.text=hospital.localHospital?.name

            if (hospital.status?.equals("1")!!){
                binding.imgStatus.setColorFilter(Color.GREEN)
                binding.status.text="يعمل"
            }else{
                binding.imgStatus.setColorFilter(Color.RED)
                binding.status.text="لا يعمل"
            }
            binding.listItem= hospital

            binding.btnDoctors.setOnClickListener{
                val intent = Intent(itemView.context, HospitalDetailsActivity::class.java)
                intent.putExtra("id",hospital.id.toString())

                Log.e("Hospital id", hospital.id.toString())

                itemView.context.startActivity(intent)
            }
        }


    }


}