package com.fouad.alfouad.ui.Services

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fouad.alfouad.R
import com.fouad.alfouad.ViewModel.InterviewViewModel
import com.fouad.alfouad.databinding.ActivityDoctorInterviewBinding

class DoctorInterView : AppCompatActivity(R.layout.activity_doctor_interview) {
    private  lateinit var binding: ActivityDoctorInterviewBinding
    private lateinit var viewModel: InterviewViewModel
    private  lateinit var userId:String
//    private val blogInterView = mutableListOf<ResponseInterView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorInterviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userId = "1"//intent.getStringExtra("id").toString()
        Log.e("id : ",userId)
        viewModel = ViewModelProvider(this).get(InterviewViewModel::class.java)
//        getInterViews()
    }

//    private fun getInterViews (){
//        viewModel.interviews.observe(this, Observer {
//                interviews_->
//            blogInterView.addAll(interviews_)
////            adapter = ClinkAdapter(blogInterView)
////            binding.recycleClinks.adapter = adapter
//        })
//        viewModel.get_interviews(1)
//
//        Log.e("response ",blogInterView.toString())
//    }

}