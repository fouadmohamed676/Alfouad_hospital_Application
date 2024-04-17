package com.fouad.alfouad.ui.Services.Forwars

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fouad.alfouad.Adapter.ForwardsAdapter
import com.fouad.alfouad.Adapter.SicksAdapter
import com.fouad.alfouad.Forward
import com.fouad.alfouad.Model.pation.Sick
import com.fouad.alfouad.R
import com.fouad.alfouad.ViewModel.ForwardsViewModel
import com.fouad.alfouad.databinding.ActivityForwardsBinding

class ActivityProfile :AppCompatActivity(R.layout.activity_forwards) {
    private lateinit var binding:ActivityForwardsBinding

    private lateinit var manager : RecyclerView.LayoutManager
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var layoutManagerBlood: RecyclerView.LayoutManager
    private lateinit var adapter: ForwardsAdapter
    private lateinit var adapterSick: SicksAdapter
    private val blogForward = mutableListOf<Forward>()
    private val blogSicks = mutableListOf<Sick>()
    private  var user_id :Int =-1
    private lateinit var viewModel: ForwardsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityForwardsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        user_id = intent.getStringExtra("user_id")?.toInt()!!
        viewModel = ViewModelProvider(this).get(ForwardsViewModel::class.java)
        responses()
    }


    private fun response() {
        viewModel.getForward.observe(this, Observer{
            listData->
            blogForward.addAll(listData)
            adapter = ForwardsAdapter(this,blogForward)
            binding.recycleForwards.adapter = adapter
        })
        viewModel.allForwards(user_id)
    }
    private fun pation() {
        viewModel.getPation.observe(this, Observer{
            response->
            binding.tvName.text=response.name
            binding.tvEmail.text=response.email
            binding.tvPhone.text=response.phone
            binding.tvBloodType.text=response.blood.name
        })
        viewModel.getPation(user_id)

    }
    private fun sick() {
        viewModel.getSicks.observe(this, Observer{
            sicks->

            blogSicks.addAll(sicks)
            adapterSick = SicksAdapter(this,blogSicks)
            binding.recycleSick.adapter = adapterSick

            Log.e(TAG,"list of sicks $sicks")
        })
        viewModel.sicks(user_id)
    }

    private fun setup(){
        manager= LinearLayoutManager(this)
        layoutManager= LinearLayoutManager(this)
        binding.recycleForwards.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.recycleForwards.layoutManager = layoutManager
        binding.recycleForwards.setHasFixedSize(true)
    }
    private fun setupBlood(){
        layoutManagerBlood = LinearLayoutManager(this)
        binding.recycleSick.setHasFixedSize(true)
        binding.recycleSick.layoutManager =LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

    }

    private fun responses(){
        setup()
        pation()
        response()
        sick()
        setupBlood()
    }

}