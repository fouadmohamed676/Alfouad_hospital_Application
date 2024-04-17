package com.fouad.alfouad.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fouad.alfouad.Doctor
import com.fouad.alfouad.databinding.ItemNameBinding
import com.fouad.alfouad.ui.Services.DoctorActivity

@Suppress("DEPRECATION")
class HospitalDetailsAdapter(private val hospital_list: MutableList<Doctor>) :
    RecyclerView.Adapter<HospitalDetailsAdapter.HospitalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalViewHolder {
        return HospitalViewHolder(
            ItemNameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: HospitalViewHolder, position: Int) {
        holder.bind(hospital_list[position])

    }

    override fun getItemCount() = hospital_list.size

    inner class HospitalViewHolder(val binding: ItemNameBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(doctorDetails: Doctor) {
            binding.idName.text = doctorDetails.name
            binding.tvPriceInterview.text = doctorDetails.price_interview

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DoctorActivity::class.java)
                intent.putExtra("id", doctorDetails.id)
                intent.putExtra("name", doctorDetails.name)
                intent.putExtra("price", doctorDetails.price_interview)
                itemView.context.startActivity(intent)
            }


        }
    }
}