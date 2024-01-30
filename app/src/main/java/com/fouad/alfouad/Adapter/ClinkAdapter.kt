package com.fouad.alfouad.Adapter

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fouad.alfouad.Model.clink.Clink
import com.fouad.alfouad.databinding.ClincItemBinding

class ClinkAdapter(private val clinkList: List<Clink>):RecyclerView.Adapter<ClinkAdapter.ClinkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClinkViewHolder {

        return ClinkViewHolder(
        ClincItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        )
    }

    override fun getItemCount()= clinkList.size


    override fun onBindViewHolder(holder: ClinkViewHolder, position: Int) {
        val data=clinkList[position]
        holder.bind(data)

    }
    class ClinkViewHolder(val binding: ClincItemBinding):RecyclerView.ViewHolder(binding.root){
         fun bind(clink: Clink){
//             binding.local.text=clink.local?.name
//             Log.e("clink Status","${clink.status}")
//             if (clink.status!!.equals("1")){
//                 binding.status.text="يعمل"
//             }else{
//                 binding.imgStatus.setColorFilter(Color.RED)
//                 binding.status.text="لا يعمل"
//             }
//             binding.listItem=clink
        }

    }
}