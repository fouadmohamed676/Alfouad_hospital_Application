@file:Suppress("DEPRECATION")

package com.fouad.alfouad.Fragment

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fouad.alfouad.Adapter.HospitalAdapter
import com.fouad.alfouad.R
import com.fouad.alfouad.Response
import com.fouad.alfouad.ViewModel.HospitalViewModel
import com.fouad.alfouad.databinding.HospitalFragmentBinding

@Suppress("DEPRECATION")
class HospitalFragment : Fragment(R.layout.hospital_fragment) {

    private lateinit var binding: HospitalFragmentBinding
    private lateinit var progressDialog: ProgressDialog
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var adapter: HospitalAdapter
    private lateinit var viewModel: HospitalViewModel
    private val blogHospital = mutableListOf<Response>()

    @SuppressLint("NotifyDataSetChanged")


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.hospital_fragment, container, false)
        viewModel = ViewModelProvider(this).get(HospitalViewModel::class.java)
        progressDialog = ProgressDialog(activity)
        setupLayout()
        strDialog()
        response()
        return binding.root
    }


    @SuppressLint("NotifyDataSetChanged")
    fun response() {
        stpDialog()
        viewModel.hospitals.observe(this, Observer { hospitals ->
            try {

                blogHospital.addAll(hospitals)
                sendData(hospitals)

            } catch (e: Exception) {
                Toast.makeText(context, "Error try Again", Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.getHospitals()
//        progressDialog.dismiss()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun sendData(hospitals: List<Response>) {
        adapter = HospitalAdapter(this.requireContext(), hospitals)
        adapter.notifyDataSetChanged()
        binding.recyclerView.adapter = adapter
    }

    private fun setupLayout() {
        manager = LinearLayoutManager(activity)
        layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.layoutManager =
            LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.setHasFixedSize(true)
    }

    private fun strDialog() {
        progressDialog.setTitle("الرجاء الانتظار")
        progressDialog.show()
        progressDialog.setCancelable(false)

    }

    private fun stpDialog() {
        progressDialog.dismiss()
    }

}


