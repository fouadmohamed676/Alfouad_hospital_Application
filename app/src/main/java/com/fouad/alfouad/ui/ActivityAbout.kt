package com.fouad.alfouad.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fouad.alfouad.databinding.ActivityAboutBinding

class ActivityAbout :AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}