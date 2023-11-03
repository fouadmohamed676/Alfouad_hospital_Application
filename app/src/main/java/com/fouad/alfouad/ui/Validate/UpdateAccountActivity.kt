package com.fouad.alfouad.ui.Validate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fouad.alfouad.R
import com.fouad.alfouad.databinding.ActivityUpdateAccountBinding

class UpdateAccountActivity :AppCompatActivity(R.layout.activity_update_account) {

    private lateinit var binding: ActivityUpdateAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityUpdateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}