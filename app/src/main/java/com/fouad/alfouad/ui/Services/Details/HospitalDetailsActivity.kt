package com.fouad.alfouad.ui.Services.Details

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fouad.alfouad.Adapter.HospitalDetailsAdapter
import com.fouad.alfouad.Doctor
import com.fouad.alfouad.R
import com.fouad.alfouad.ViewModel.HospitalDetailsViewModel
import com.fouad.alfouad.databinding.ActicivtyDetailsHospitalBinding

@Suppress("DEPRECATION")
class HospitalDetailsActivity : AppCompatActivity(R.layout.acticivty_details_hospital) {

    private lateinit var binding: ActicivtyDetailsHospitalBinding

    private val doctorsList = mutableListOf<Doctor>()
    private val doctorsDaysList = mutableListOf<Doctor>()
    private lateinit var adapter: HospitalDetailsAdapter
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var viewModel: HospitalDetailsViewModel
    private lateinit var name: String
    private lateinit var phone: String
    private lateinit var specialization: String
    private lateinit var local: String
    private lateinit var price: String
    private lateinit var address: String
    private var hospitalId = -19
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActicivtyDetailsHospitalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(HospitalDetailsViewModel::class.java)

        hospitalId = intent.getIntExtra("id", -1)
        local = intent.getStringExtra("local").toString()
        phone = intent.getStringExtra("phone").toString()
        address = intent.getStringExtra("address").toString()
        price = intent.getStringExtra("price").toString()
        name = intent.getStringExtra("name").toString()
        specialization = intent.getStringExtra("specialization").toString()

        setupLayout()
        setData()
        response()


    }

    @SuppressLint("NotifyDataSetChanged")
    fun response() {
        viewModel.details.observe(this, Observer { doctors ->
            Log.e("doc : ",doctors.toString())
            doctorsList.addAll(doctors)
            doctorsDaysList.addAll(doctors)
            adapter = HospitalDetailsAdapter(doctorsList)
            adapter.notifyDataSetChanged()
            binding.hospitalDetails.adapter = adapter
        })
        viewModel.hospitalDetails(hospitalId) //get hospital doctors with Hospital_id
    }


    private fun setData() {
        binding.nameTv.text = name
        binding.tvLocal.text = local
        binding.tvPrice.text = price
        binding.tvPhone.text = phone
        binding.tvAddress.text = address
        binding.tvspiz.text = specialization
    }

    private fun setupLayout() {
        manager = LinearLayoutManager(this)
        layoutManager = LinearLayoutManager(this)
        binding.hospitalDetails.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.hospitalDetails.layoutManager = layoutManager
        binding.hospitalDetails.setHasFixedSize(true)
    }


}