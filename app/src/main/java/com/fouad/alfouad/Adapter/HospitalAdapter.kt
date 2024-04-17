package com.fouad.alfouad.Adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fouad.alfouad.Response
import com.fouad.alfouad.databinding.HospitalItemBinding
import com.fouad.alfouad.ui.Services.Details.HospitalDetailsActivity


class HospitalAdapter(private val context: Context, private val hospital_list: List<Response>) :
    RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalViewHolder {
        return HospitalViewHolder(
            HospitalItemBinding.inflate(LayoutInflater.from(context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: HospitalViewHolder, position: Int) {
        holder.bind(hospital_list[position])

    }

    override fun getItemCount() = hospital_list.size

    inner class HospitalViewHolder(val binding: HospitalItemBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(hospital: Response) {

            binding.splizeetion.text = hospital.specialization.name
            binding.local.text = hospital.local.name

            if ((hospital.status == "1")) {
                binding.imgStatus.setColorFilter(Color.GREEN)
                binding.status.text = "يعمل"
            } else {
                binding.imgStatus.setColorFilter(Color.RED)
                binding.status.text = "لا يعمل"
            }
            binding.listItem = hospital

            binding.btnDoctors.setOnClickListener {
                val intent = Intent(itemView.context, HospitalDetailsActivity::class.java)
                intent.putExtra("id", hospital.id)
                intent.putExtra("name", hospital.dis)
                intent.putExtra("phone", hospital.phone)
                intent.putExtra("address", hospital.address)
                intent.putExtra("local", hospital.local.name)
                intent.putExtra("price", hospital.enter_price)
                intent.putExtra("specialization", hospital.specialization.name)
                itemView.context.startActivity(intent)
            }
        }


    }


}