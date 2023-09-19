package com.fouad.alfouad.ui.Validate

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fouad.alfouad.R
import com.fouad.alfouad.databinding.ActivityRegisterBinding
import com.fouad.alfouad.ui.Splash.HomeActivity

class RegisterActivity :AppCompatActivity(R.layout.activity_register) {
    lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.register.setOnClickListener{
            val intent=Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}