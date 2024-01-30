package com.fouad.alfouad.Adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.fouad.alfouad.Fragment.EXTRA
import com.fouad.alfouad.Response
import com.fouad.alfouad.databinding.HospitalItemBinding
import com.fouad.alfouad.ui.Services.Details.HospitalDetailsActivity
import java.util.Objects

//class HospitalAdapter(private val context: Context,private val hospital_list: List<Response>,private val itemClickListener: ItemClickListener)
//    :RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder>(){
class HospitalAdapter(private val context: Context,private val hospital_list: List<Response>)
    :RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder>(){

// interface ItemClickListener{
//    fun  onItemClickListener(hospital: Response)
//}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalViewHolder {
        return HospitalViewHolder(
            HospitalItemBinding.inflate(LayoutInflater.from(context), parent, false)
        )
    }
    override fun onBindViewHolder(holder: HospitalViewHolder, position: Int) {
        holder.bind(hospital_list[position])

    }
    override fun getItemCount()=hospital_list.size

    inner class HospitalViewHolder(val binding:HospitalItemBinding) : RecyclerView.ViewHolder(binding.root){


        fun bind(hospital: Response){

            binding.splizeetion.text=hospital.specialization.name
            binding.local.text= hospital.local.name

            Log.e("hospital.id","${hospital.id}")
            if ((hospital.status == "1")){
                binding.imgStatus.setColorFilter(Color.GREEN)
                binding.status.text="يعمل"
            }else{
                binding.imgStatus.setColorFilter(Color.RED)
                binding.status.text="لا يعمل"
            }
            binding.listItem= hospital
//            itemView.setOnClickListener {
//
//                itemClickListener.onItemClickListener(hospital)
//            }
            binding.btnDoctors.setOnClickListener{
                val intent = Intent(itemView.context, HospitalDetailsActivity::class.java)
                intent.putExtra(EXTRA,hospital)

                Log.e("putExtra : "," $hospital")
//                intent.putExtra("EXTRA",hospital)
                itemView.context.startActivity(intent)
            }
        }


    }


}