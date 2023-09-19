package com.fouad.alfouad.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fouad.alfouad.Clinck
import com.fouad.alfouad.databinding.ClincItemBinding

class ClinkAdapter(private val clinkList: List<Clinck>):RecyclerView.Adapter<ClinkAdapter.ClinkViewHolder>() {

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
         fun bind(clink: Clinck){
             binding.listItem=clink
             Log.e("Clink ","data  : $clink")

        }

    }
}