package com.fouad.alfouad.Adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fouad.alfouad.DoctorHospital
import com.fouad.alfouad.databinding.HospitalDocotrsItemBinding

class HospitalDoctorAdapter(
    private val context: Context,
    private val hospitalList: List<DoctorHospital>
) : RecyclerView.Adapter<HospitalDoctorAdapter.HospitalViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalViewHolder {
        return HospitalViewHolder(
            HospitalDocotrsItemBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = hospitalList.size

    override fun onBindViewHolder(holder: HospitalViewHolder, position: Int) {
        return holder.bind(hospitalList[position])
    }

    class HospitalViewHolder(val binding: HospitalDocotrsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(hospital: DoctorHospital) {
            if ((hospital.status == 1)) {
                binding.imgStatus.setColorFilter(Color.GREEN)
                binding.status.text = "يعمل"
            } else {
                binding.imgStatus.setColorFilter(Color.RED)
                binding.status.text = "لا يعمل"
            }

            binding.listItem = hospital

        }
    }
}