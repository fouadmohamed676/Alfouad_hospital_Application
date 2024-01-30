package com.fouad.alfouad.user

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.fouad.alfouad.R
import com.fouad.alfouad.databinding.ActivityAddInterviewBinding

class Add_InterView :AppCompatActivity(R.layout.activity_add_interview) {
    private  lateinit var binding: ActivityAddInterviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddInterviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    private  fun interview(){

    }
}