package com.fouad.alfouad.Adapter

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fouad.alfouad.ResponseClink
import com.fouad.alfouad.databinding.ClincItemBinding

class ClinkAdapter(private val context: Context, private val clinkList: List<ResponseClink>) :
    RecyclerView.Adapter<ClinkAdapter.ClinkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClinkViewHolder {

        return ClinkViewHolder(
            ClincItemBinding.inflate(LayoutInflater.from(context), parent, false)

        )
    }

    override fun getItemCount() = clinkList.size


    override fun onBindViewHolder(holder: ClinkViewHolder, position: Int) {
        val data = clinkList[position]
        holder.bind(data)

    }

    class ClinkViewHolder(val binding: ClincItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(clink: ResponseClink) {
            binding.local.text = clink.local?.name
//            Log.e("clink Status", "${clink.status}")
            if (clink.status == "1") {
                binding.status.text = "يعمل"
            } else {
                binding.imgStatus.setColorFilter(Color.RED)
                binding.status.text = "لا يعمل"
            }
            binding.listItem = clink
        }

    }
}