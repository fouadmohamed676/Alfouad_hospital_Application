package com.fouad.alfouad.ui.Services

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fouad.alfouad.Adapter.DayAdapter
import com.fouad.alfouad.Adapter.HospitalDoctorAdapter
import com.fouad.alfouad.DoctorHospital
import com.fouad.alfouad.R
import com.fouad.alfouad.Time
import com.fouad.alfouad.ViewModel.DoctorViewModel
import com.fouad.alfouad.databinding.ActivityDoctorBinding

class DoctorActivity : AppCompatActivity(R.layout.activity_doctor) {
    private lateinit var binding: ActivityDoctorBinding
    private lateinit var viewModel: DoctorViewModel
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var managerDoctor: RecyclerView.LayoutManager
    private lateinit var layoutManagerDoctor: RecyclerView.LayoutManager
    private lateinit var adapter: HospitalDoctorAdapter
    private lateinit var dayAdapter: DayAdapter

    private lateinit var hospitalDoctorAdapter: HospitalDoctorAdapter
    private lateinit var name: String
    private lateinit var price: String
    private var doctorId: Int = -1
    private val blogDataDays = mutableListOf<Time>()
    private val blogHospitals = mutableListOf<DoctorHospital>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(DoctorViewModel::class.java)

        doctorId = intent.getIntExtra("id", -1)
        name = intent.getStringExtra("name").toString()
        price = intent.getStringExtra("price").toString()

        setup()
        response()
        responseTimes()
        responseHospitals()

    }

    // get patent data from id
    @SuppressLint("NotifyDataSetChanged")
    private fun response() {
        viewModel.getDoctor.observe(this, Observer { myResponse ->

            try {

                Log.e("response Doctor data ", myResponse.toString())

            } catch (e: Exception) {

                Log.e(" Error response Doctor data ", e.message.toString())
            }


            if (myResponse != null) {

                binding.name.text = myResponse.name
                binding.sp.text = myResponse.specialization.name
                binding.price.text = myResponse.price_interview
            } else
                Toast.makeText(this, "try Again later", Toast.LENGTH_SHORT).show()
            binding.name.text = name
            binding.price.text = price
        })
        viewModel.myDoctors(doctorId)
    }


    //    doctor week days
    @SuppressLint("NotifyDataSetChanged")
    private fun responseTimes() {
        viewModel.getDoctorDays.observe(this, Observer { myDays ->
            try {

                Log.e(" response Times ", myDays.toString())
            } catch (e: Exception) {

                Log.e(" Error response Times ", e.message.toString())
            }
            if (myDays != null) {
                blogDataDays.addAll(myDays)
                dayAdapter = DayAdapter(this, blogDataDays)
                binding.recycleDaysDoctor.adapter = dayAdapter
                dayAdapter.notifyDataSetChanged()
            } else {
                Log.e(" recycler Days Doctor ", "null")
            }
        })
        viewModel.myDoctorsDays(doctorId)
    }

    @SuppressLint("NotifyDataSetChanged")


    private fun responseHospitals() {
        viewModel.getDoctorHospitals.observe(this, Observer { myHospitals ->

            try {
                blogHospitals.addAll(myHospitals)
                hospitalDoctorAdapter = HospitalDoctorAdapter(this, myHospitals)
                binding.recycleHospitalsDoctor.adapter = hospitalDoctorAdapter
                hospitalDoctorAdapter.notifyDataSetChanged()

            } catch (e: Exception) {

                Log.e(" Error response Times ", e.message.toString())

            }

        })
        viewModel.myDoctorsHospitals(doctorId)
    }

    private fun setup() {
        manager = LinearLayoutManager(this)
        layoutManager = LinearLayoutManager(this)
        binding.recycleHospitalsDoctor.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.recycleHospitalsDoctor.layoutManager = layoutManager
        binding.recycleHospitalsDoctor.setHasFixedSize(true)

        layoutManagerDoctor = LinearLayoutManager(this)
        binding.recycleDaysDoctor.setHasFixedSize(true)
        binding.recycleDaysDoctor.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

    }

}