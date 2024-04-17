package com.fouad.alfouad.ui.Services

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fouad.alfouad.Adapter.addinterview.DoctorInterViewAdapter
import com.fouad.alfouad.Adapter.addinterview.DoctorSpecializationAdapter
import com.fouad.alfouad.Adapter.addinterview.HospitalInterviewAdapter
import com.fouad.alfouad.Model.SpDoctors.Doctor
import com.fouad.alfouad.Model.specialization_doctors.all_sp.Response
import com.fouad.alfouad.R
import com.fouad.alfouad.ViewModel.DoctorSpecializationViewModel
import com.fouad.alfouad.ViewModel.DoctorViewModel
import com.fouad.alfouad.databinding.ActivityAddInterviewBinding
import java.util.Calendar


class AddInterView : AppCompatActivity(R.layout.activity_add_interview) {
    private lateinit var binding: ActivityAddInterviewBinding
    private lateinit var spDoctorViewModel: DoctorSpecializationViewModel
    private lateinit var doctorViewModel: DoctorViewModel
    private val spList = mutableListOf<Response>()
    private val doctorList = mutableListOf<Doctor>()
    private var doctorIdSelected: Int = -1
    private var hospitalIdSelected: Int = -1
    private var spIdSelected: Int = -1
    private val calendar: Calendar = Calendar.getInstance()
    private val year_: Int = calendar.get(Calendar.YEAR)
    private val month_: Int = calendar.get(Calendar.MONTH)
    private val day_: Int = calendar.get(Calendar.DAY_OF_MONTH)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddInterviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        spDoctorViewModel = ViewModelProvider(this).get(DoctorSpecializationViewModel::class.java)
        doctorViewModel = ViewModelProvider(this).get(DoctorViewModel::class.java)

        getSps()
        binding.regDate.setOnClickListener {
            myDate()
        }
        binding.register.setOnClickListener {
            Log.e(
                "Submit ",
                "hospitalId  : $hospitalIdSelected \n doctorId : $doctorIdSelected \n Sp : $spIdSelected"
            )
        }

    }


    private fun getSps() {
        spList.clear()
        spDoctorViewModel.spDoctors.observe(this, Observer { spDoctorList ->

            spList.addAll(spDoctorList)
            binding.spinnerSp.adapter = DoctorSpecializationAdapter(this, spList)

            binding.spinnerSp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    positoin: Int,
                    id: Long
                ) {
                    spIdSelected = spList[binding.spinnerSp.selectedItemPosition].id
                    getDoctorSp(spIdSelected)

                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }
            }
        })
        spDoctorViewModel.getAllDoctorSps()
    }


    private fun getDoctorSp(doctorId: Int) {

        spDoctorViewModel.myDoctors.observe(this, Observer { myDoctors ->
            doctorList.clear()
            doctorList.addAll(myDoctors)

            binding.spinnerDoctor.adapter = DoctorInterViewAdapter(this, doctorList.toMutableList())
            binding.spinnerDoctor.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        p0: AdapterView<*>?,
                        view: View?,
                        positoin: Int,
                        p3: Long
                    ) {
                        doctorIdSelected = doctorList[binding.spinnerDoctor.selectedItemPosition].id

                        response(doctorIdSelected)

                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {}
                }
        })
        spDoctorViewModel.doctors(doctorId)
    }

    private fun response(doctorId: Int) {
        doctorViewModel.getDoctorHospitals.observe(this, Observer { myResponse ->

            try {

                if (myResponse != null) {

                    binding.spinnerHospitals.adapter = HospitalInterviewAdapter(this, myResponse)

                    binding.spinnerHospitals.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                p0: AdapterView<*>?,
                                view: View?,
                                positoin: Int,
                                p3: Long
                            ) {

                                hospitalIdSelected =
                                    doctorList[binding.spinnerHospitals.selectedItemPosition].id


                            }

                            override fun onNothingSelected(p0: AdapterView<*>?) {}
                        }

                }

            } catch (e: Exception) {

                Log.e(" Error response Doctor data ", e.message.toString())
            }

        })
        doctorViewModel.myDoctorsHospitals(doctorId)
    }


    @SuppressLint("SetTextI18n")
    fun myDate() {
        val datePickerDialog = DatePickerDialog(
            this,
            { view, year, month, day ->
                binding.regDate.setText("$year-" + 1.plus(month).toString() + "-$day")
//                Log.e("date : ", "$year-" + 1.plus(month).toString() + "-$day")
            }, year_, month_, day_
        )
        datePickerDialog.setTitle("تاريخ الحجز")
        datePickerDialog.show()
    }


}