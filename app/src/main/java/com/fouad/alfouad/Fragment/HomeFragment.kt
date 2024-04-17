@file:Suppress("DEPRECATION")

package com.fouad.alfouad.Fragment

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fouad.alfouad.Adapter.SpDoctorsAdapter
import com.fouad.alfouad.Model.specializations_hospital.all_sp_hospitals.ResponseAllSpHospitals
import com.fouad.alfouad.R
import com.fouad.alfouad.ResponseDoctorsSp
import com.fouad.alfouad.ViewModel.BestDoctorsViewModel
import com.fouad.alfouad.ViewModel.BestHospitalsViewModel
import com.fouad.alfouad.ViewModel.DoctorSpecializationViewModel
import com.fouad.alfouad.ViewModel.HospitalSpecializationViewModel
import com.fouad.alfouad.databinding.HomeFragmentBinding
import com.fouad.alfouad.ui.ActivityAbout
import com.fouad.alfouad.ui.Services.AddInterView
import com.fouad.alfouad.ui.Services.ClinkActivity
import com.fouad.alfouad.ui.Services.PharmacyActivity

@Suppress("DEPRECATION")
class HomeFragment : Fragment(R.layout.home_fragment) {

    private lateinit var binding: HomeFragmentBinding
    lateinit var progressDialog: ProgressDialog
    private lateinit var userId: String
    private lateinit var spDoctorsSp: List<ResponseDoctorsSp>
    private lateinit var spHospitalsSp: List<ResponseAllSpHospitals>
    private val blogDoctor = mutableListOf<ResponseDoctorsSp>()
    private val blogHospital = mutableListOf<ResponseAllSpHospitals>()
    private lateinit var doctorSpViewModel: DoctorSpecializationViewModel
    private lateinit var hospitalSpViewModel: HospitalSpecializationViewModel
    private lateinit var bestDoctorsViewModel: BestDoctorsViewModel
    private lateinit var bestHospitalsViewModel: BestHospitalsViewModel
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var adapter: SpDoctorsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        userId = arguments?.getString("email").toString()
        progressDialog = ProgressDialog(activity)
//        Log.e("email",userId)
        doctorSpViewModel = ViewModelProvider(this).get(
            DoctorSpecializationViewModel::class.java
        )
        hospitalSpViewModel =
            ViewModelProvider(this).get(HospitalSpecializationViewModel::class.java)
        bestDoctorsViewModel = ViewModelProvider(this).get(BestDoctorsViewModel::class.java)
        bestHospitalsViewModel = ViewModelProvider(this).get(BestHospitalsViewModel::class.java)

//        setupLayout()
//        spDoctorsSp = arrayListOf(
//            ResponseDoctorsSp(1, "رسم قلب"),
//            ResponseDoctorsSp(1, "ضغط الدم"),
//
//        )
//        spHospitalsSp = arrayListOf(
//            ResponseAllSpHospitals(1, "الطوارئ والاصابات"),
//            ResponseAllSpHospitals(1, "عمليات صغيره"),
//            ResponseAllSpHospitals(1, "عظام"),
//        )


//        hospitalsSpResponse()
//        doctorSpResponse()
//        bestHospitals()
//        bestDoctors()



        binding.clink.setOnClickListener {
            val intentClink = Intent(activity, ClinkActivity::class.java)
            startActivity(intentClink)
        }
        binding.pharmBtn.setOnClickListener {
            val intent = Intent(activity, PharmacyActivity::class.java)
            startActivity(intent)
        }
        binding.about.setOnClickListener {
            val intent = Intent(activity, ActivityAbout::class.java)
            startActivity(intent)
        }
        binding.interviewes.setOnClickListener {
            val intent = Intent(activity, AddInterView::class.java)
            startActivity(intent)
        }
        return binding.root
    }


    private fun setupLayout() {
//        manager = LinearLayoutManager(activity)
//        layoutManager = LinearLayoutManager(activity)
//        binding.recyclerDoctorsSp.layoutManager = layoutManager
//        binding.recyclerDoctorsSp.layoutManager =
//            LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
//        binding.recyclerDoctorsSp.setHasFixedSize(true)
//
//        binding.recyclerHospitalsSp.layoutManager = layoutManager
//        binding.recyclerHospitalsSp.layoutManager =
//            LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
//        binding.recyclerHospitalsSp.setHasFixedSize(true)


    }

    private fun bestDoctors() {
        bestDoctorsViewModel.responseDoctors.observe(viewLifecycleOwner, Observer { response ->

//
//            adapter = BestDoctorsAdapter(this.requireContext(), hospitals)
//            adapter.notifyDataSetChanged()
//            binding.recyclerDoctorsSp.adapter = adapter
//

//            Log.e("Response Best Doctors : ", response.toString())
        })
        bestDoctorsViewModel.getDoctorsData()
    }


    @SuppressLint("FragmentLiveDataObserve")
    private fun bestHospitals() {


        bestHospitalsViewModel.myResponseHospitals.observe(this, Observer { response ->
//            Log.e("Response Best Hospitals : ", response.toString())
        })
        bestHospitalsViewModel.getBestHospitals()

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun sendData(hospitals: List<ResponseDoctorsSp>) {
        adapter = SpDoctorsAdapter(this.requireContext(), hospitals)
        adapter.notifyDataSetChanged()
//        binding.recyclerDoctorsSp.adapter = adapter
    }

    private fun doctorSpResponse() {


        blogDoctor.addAll(spDoctorsSp)
        sendData(blogDoctor)


        doctorSpViewModel.spDoctors.observe(this, Observer { myResponseDoctorSp ->

//
//            blogHospital.addAll(myResponseDoctorSp)
//            adapter = SpDoctorsAdapter(this.requireContext(), blogDoctor)
//            adapter.notifyDataSetChanged()
//            binding.recyclerHospitalsSp.adapter = adapter
//

            Log.e("TAG", " doctors Sp  : $myResponseDoctorSp")
        })

    }

    @SuppressLint("NotifyDataSetChanged", "FragmentLiveDataObserve")
    private fun hospitalsSpResponse() {

        hospitalSpViewModel.hospitalList.observe(this, Observer { myResponseHospitalSp ->
//            Log.e("TAG", " hospitals Sp  : $myResponseHospitalSp")


            blogHospital.addAll(myResponseHospitalSp)
            adapter = SpDoctorsAdapter(this.requireContext(), blogDoctor)
            adapter.notifyDataSetChanged()
//            binding.recyclerHospitalsSp.adapter = adapter



        })
        hospitalSpViewModel.myAllHospitalsSp()
    }


}