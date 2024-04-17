package com.fouad.alfouad.ui.Services.Bests

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fouad.alfouad.R
import com.fouad.alfouad.databinding.ActivityBestHospitalsBinding

class ActivityBestHospitals : AppCompatActivity(R.layout.activity_best_hospitals) {
    private lateinit var binding: ActivityBestHospitalsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBestHospitalsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}