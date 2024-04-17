package com.fouad.alfouad.ui.Services

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fouad.alfouad.Adapter.PharmacyAdapter
import com.fouad.alfouad.R
import com.fouad.alfouad.ResponsePharmacy
import com.fouad.alfouad.ViewModel.PharmacyViewModel
import com.fouad.alfouad.databinding.ActivityPharmacyBinding

const val EXTRA_PHARMACY="EXTRA_PHARMACY"
class PharmacyActivity : AppCompatActivity(R.layout.activity_pharmacy) {
    private lateinit var binding: ActivityPharmacyBinding
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var adapter: PharmacyAdapter
    private lateinit var viewModel: PharmacyViewModel
    private val blogPharmacy = mutableListOf<ResponsePharmacy>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPharmacyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(PharmacyViewModel::class.java)

        setup()
        response()
    }

    private fun response() {
        viewModel.allPharmacy.observe(this, Observer { response ->
//            Log.e("response Pharmacy List", "$response")
            blogPharmacy.addAll(response)
            adapter = PharmacyAdapter(this, blogPharmacy)
            binding.recyclePharmacy.adapter = adapter
        })
        viewModel.getData()
    }

    private fun setup() {
        manager = LinearLayoutManager(this)
        layoutManager = LinearLayoutManager(this)
        binding.recyclePharmacy.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.recyclePharmacy.layoutManager = layoutManager
        binding.recyclePharmacy.setHasFixedSize(true)
    }


}