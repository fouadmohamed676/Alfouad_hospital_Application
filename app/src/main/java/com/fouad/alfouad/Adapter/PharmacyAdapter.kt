package com.fouad.alfouad.Adapter

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fouad.alfouad.Response
import com.fouad.alfouad.databinding.PharmacyItemBinding

class PharmacyAdapter(private val clinkList: List<Response>):RecyclerView.Adapter<PharmacyAdapter.ClinkViewHolder>() {

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
        fun bind(pharmacy: Response){
//            binding.time.text=pharmacy.time_work
//            if (pharmacy.status=="1"){
//                binding.status.text="يعمل"
//            }else{
//                binding.imgStatus.setColorFilter(Color.RED)
//                binding.status.text="لا يعمل"
//            }
//            binding.listItem= pharmacy

            itemView.setOnClickListener {
//                Log.e("OnClick : ","id : "+pharmacy.id +"name : ${pharmacy.name}")
//                val intent =Intent(itemView.context,HospitalActivity::class.java)
//                intent.putExtra("id",pharmacy.id)
//               itemView.context.startActivity(intent)
            }

        }

    }
}