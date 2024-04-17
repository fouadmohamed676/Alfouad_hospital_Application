package com.fouad.alfouad.ui.Services.Bests

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fouad.alfouad.R
import com.fouad.alfouad.databinding.ActivityBestDoctorsBinding

class ActivityBestDoctors :AppCompatActivity(R.layout.activity_best_doctors) {
    private lateinit var binding: ActivityBestDoctorsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBestDoctorsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}