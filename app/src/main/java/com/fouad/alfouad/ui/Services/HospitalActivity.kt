package com.fouad.alfouad.ui.Services

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fouad.alfouad.Adapter.HospitalAdapter
import com.fouad.alfouad.R
import com.fouad.alfouad.databinding.ActivityHospitalBinding


class HospitalActivity : AppCompatActivity(R.layout.activity_hospital) {
    lateinit var binding: ActivityHospitalBinding
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private val hospitalList: ArrayList<com.fouad.alfouad.Response> = ArrayList()
    private lateinit var adapter: HospitalAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHospitalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupLayout()
//        getData()
//            data()
    }

    private fun setupLayout() {

        manager = LinearLayoutManager(this)
        layoutManager = LinearLayoutManager(this)
        binding.hospitalRecycler.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.hospitalRecycler.layoutManager = layoutManager
        binding.hospitalRecycler.setHasFixedSize(true)
    }

//    private  fun data(){
//        val quotesApi = RetrofitHelper.getInstance().create(ApiInterface::class.java)
//        // launching a new coroutine
//        GlobalScope.launch {
//            val result = quotesApi.getHospitals()
//            if (result != null)
//            // Checking the results
//                Log.d("result : ", result.toString())
//        }
//    }


}




