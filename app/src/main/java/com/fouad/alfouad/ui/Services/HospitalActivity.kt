package com.fouad.alfouad.ui.Services

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fouad.alfouad.Adapter.HospitalAdapter
import com.fouad.alfouad.Hospital
import com.fouad.alfouad.Network.ApiInterface
import com.fouad.alfouad.Network.RetrofitClient
import com.fouad.alfouad.R
import com.fouad.alfouad.databinding.ActivityHospitalBinding


class HospitalActivity :AppCompatActivity(R.layout.activity_hospital){
    lateinit var binding: ActivityHospitalBinding
    private lateinit var manager :RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHospitalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        manager=LinearLayoutManager(this)

        val data= listOf(
            Hospital("1","مستشفي السلاح الطبي","khartoum","general"),
            Hospital("2","مستشفى الخرطوم التعليمي","khartoum","general"),
            Hospital("2","مستشفى الروضة","khartoum","general"),
            Hospital("2","مستشفى الفؤاد التخصصي ","الصحافة","general"),
            Hospital("2","مستشفى الراهبات  الموردة","الطائف","general"),
            Hospital("2","مستشفي الكاملين التخصصي ","الكاملين","general"),
            Hospital("2","الدوحه مستشفي","khartoum","general"),
            Hospital("2","مستشفي السلاح الطبي ","khartoum","general"),
            Hospital("1","مشتشفي احمد قاسم ","khartoum","general"),
            Hospital("1","مستشفي الجودة","khartoum","general")
        )
        binding.hospitalRecycler.apply {
            adapter=HospitalAdapter(data)
           layoutManager=manager
        }
    }

    fun getUserList() {
        val retrofit = RetrofitClient.getInstance()
        val apiInterface = retrofit.create(ApiInterface::class.java)
        lifecycleScope.launchWhenCreated {
            try {
                val response = apiInterface.getAllUsers()
                if (response.isSuccess) {
                    //your code for handaling success response

                    Log.e("Success:- ","$response")

                } else {

                    Log.e("Error:- ","No Response")
                    Toast.makeText(
                        this@HospitalActivity,
                        response.error.toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }catch (Ex:Exception){

                Ex.localizedMessage?.let { Log.e("Error", it) }
//                Log.e("Error",Ex.localizedMessage)
            }
        }

    }
    private fun getHospital(){
        Log.e("Hospital","Hospital data : Loading..")
    }





    }




