package com.fouad.alfouad.Adapter

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fouad.alfouad.ResponsePharmacy
import com.fouad.alfouad.databinding.PharmacyItemBinding
import com.fouad.alfouad.ui.Services.Details.PharmacyDetailsActivity
import com.fouad.alfouad.ui.Services.EXTRA_PHARMACY

class PharmacyAdapter(private val context: Context, private val pharmacyList: List<ResponsePharmacy>) :
    RecyclerView.Adapter<PharmacyAdapter.ClinkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClinkViewHolder {

        return ClinkViewHolder(
            PharmacyItemBinding.inflate(LayoutInflater.from(context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return pharmacyList.size
    }

    override fun onBindViewHolder(holder: ClinkViewHolder, position: Int) {
        val data = pharmacyList[position]
        holder.bind(data)
    }

    class ClinkViewHolder(val binding: PharmacyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pharmacy: ResponsePharmacy) {
//            Log.e(TAG, "PharmacyAdapter :  ${pharmacy.status}")
            binding.tvLocal.text = pharmacy.local.id.toString()
            if (pharmacy.status == 1) {
                binding.imgStatus.setColorFilter(Color.GREEN)
                binding.status.text = "تعمل"
            } else if ((pharmacy.status == 0)){
                binding.imgStatus.setColorFilter(Color.RED)
                binding.status.text = "لا تعمل"
            }
            binding.listItem = pharmacy

            binding.btnDays.setOnClickListener {
                val intent = Intent(itemView.context, PharmacyDetailsActivity::class.java)
                Log.e(TAG, "PharmacyAdapter pharmacy_id = ${pharmacy.id}")
                intent.putExtra(EXTRA_PHARMACY, pharmacy.id)
                itemView.context.startActivity(intent)
            }
        }

    }
}