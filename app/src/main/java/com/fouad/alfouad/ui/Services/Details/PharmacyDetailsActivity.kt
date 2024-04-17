package com.fouad.alfouad.ui.Services.Details

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fouad.alfouad.R
import com.fouad.alfouad.ViewModel.PharmacyViewModel
import com.fouad.alfouad.databinding.ActivityDetailsPharamcyBinding
import com.fouad.alfouad.ui.Services.EXTRA_PHARMACY

@Suppress("DEPRECATION")
class PharmacyDetailsActivity : AppCompatActivity(R.layout.activity_details_pharamcy) {
    private lateinit var binding: ActivityDetailsPharamcyBinding
    private lateinit var viewModel: PharmacyViewModel
//    private lateinit var pharmacy_id :
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsPharamcyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(PharmacyViewModel::class.java)
        val pharmacy_id=intent.getIntExtra(EXTRA_PHARMACY,-1)

        Log.e("pharmacy_id ", "$pharmacy_id")
        getDays()
//        getStaffs()

    }

    private fun getStaffs() {
        viewModel.staffsPharmacy.observe(this, Observer {
                myResponse ->
            Log.e("Pharmacy Staffs Response.. ", "$myResponse")
        })
        viewModel.getStaffs(1)
    }

    private fun getDays() {
        viewModel.daysPharmacy.observe(this, Observer {
                myResponseDays ->
            Log.e("Pharmacy Days Response.. ", "$myResponseDays")
        })
        viewModel.getDays(1)
    }
}