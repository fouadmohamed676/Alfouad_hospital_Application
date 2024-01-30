package com.fouad.alfouad.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fouad.alfouad.Response
import com.fouad.alfouad.databinding.ItemNameBinding

@Suppress("DEPRECATION")
class HospitalDetailsAdapter(private val hospital_list: List<Response>): RecyclerView.Adapter<HospitalDetailsAdapter.HospitalViewHolder>(){

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
        fun bind(hospitalDetails: Response){
//            val index =position+1
//            binding.position.text=index.toString()
//            binding.idName.text=hospitalDetails.doctors.getString("name")
        }
    }
}