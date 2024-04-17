package com.fouad.alfouad.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fouad.alfouad.Forward
import com.fouad.alfouad.databinding.ForwardsItemBinding

class ForwardsAdapter(private val context: Context, private val forwardList: List<Forward>) :
    RecyclerView.Adapter<ForwardsAdapter.ForwardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForwardViewHolder {

        return ForwardViewHolder(
            ForwardsItemBinding.inflate(LayoutInflater.from(context), parent, false)

        )
    }

    override fun getItemCount() = forwardList.size


    override fun onBindViewHolder(holder: ForwardViewHolder, position: Int) {
        val data = forwardList[position]
        holder.bind(data)

    }

    class ForwardViewHolder(val binding: ForwardsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(forward: Forward) {
//            Log.e("TAG ","PATION DATA : ${forward}")
            binding.listItem = forward
        }

    }
}