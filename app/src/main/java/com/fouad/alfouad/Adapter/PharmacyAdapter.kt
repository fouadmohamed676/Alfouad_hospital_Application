package com.fouad.alfouad.Adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fouad.alfouad.Pharmacy
import com.fouad.alfouad.databinding.ClincItemBinding
import com.fouad.alfouad.databinding.PharmacyItemBinding

class PharmacyAdapter(private val clinkList: List<Pharmacy>):RecyclerView.Adapter<PharmacyAdapter.ClinkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClinkViewHolder {

        return ClinkViewHolder(
            PharmacyItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        )
    }

    override fun getItemCount(): Int {
        return  clinkList.size
    }

    override fun onBindViewHolder(holder: ClinkViewHolder, position: Int) {
        val data=clinkList[position]
        holder.bind(data)

    }
    class ClinkViewHolder(val binding: PharmacyItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(pharmacy: Pharmacy){
            binding.time.text=pharmacy.time_work
            if (pharmacy.status=="1"){
                binding.status.text="يعمل"
            }else{
                binding.imgStatus.setColorFilter(Color.RED)
                binding.status.text="لا يعمل"
            }
            binding.listItem= pharmacy
        }

    }
}