package com.fouad.alfouad.Adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fouad.alfouad.Clinck
import com.fouad.alfouad.ClinkResponse
import com.fouad.alfouad.databinding.ClincItemBinding

class ClinkAdapter(private val clinkList: List<ClinkResponse>):RecyclerView.Adapter<ClinkAdapter.ClinkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClinkViewHolder {

        return ClinkViewHolder(
        ClincItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        )
    }

    override fun getItemCount(): Int {
        return  clinkList.size
    }

    override fun onBindViewHolder(holder: ClinkViewHolder, position: Int) {
        val data=clinkList[position]
        holder.bind(data)

    }
    class ClinkViewHolder(val binding: ClincItemBinding):RecyclerView.ViewHolder(binding.root){
         fun bind(clink: ClinkResponse){
             binding.local.text=clink.local?.name
             if (clink.status!!.equals("1")){
                 binding.status.text="يعمل"
             }else{
                 binding.imgStatus.setColorFilter(Color.RED)
                 binding.status.text="لا يعمل"
             }
             binding.listItem=clink
        }

    }
}