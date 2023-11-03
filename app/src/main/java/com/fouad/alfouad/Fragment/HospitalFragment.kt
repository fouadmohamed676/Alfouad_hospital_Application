@file:Suppress("DEPRECATION")

package com.fouad.alfouad.Fragment

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.fouad.alfouad.Adapter.HospitalAdapter
import com.fouad.alfouad.Hospital
import com.fouad.alfouad.HospitalPojoO
import com.fouad.alfouad.Network.Data
import com.fouad.alfouad.R
import com.fouad.alfouad.ViewModel.HospitalViewModel
import com.fouad.alfouad.databinding.HospitalFragmentBinding
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Suppress("DEPRECATION")
class HospitalFragment:Fragment(R.layout.hospital_fragment) {

   private lateinit var binding: HospitalFragmentBinding
   lateinit var progressDialog:ProgressDialog
    private lateinit var manager : RecyclerView.LayoutManager
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var adapter: HospitalAdapter
    private lateinit var viewModel: HospitalViewModel
    private val blogHospital = mutableListOf<HospitalPojoO>()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=HospitalFragmentBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(HospitalViewModel::class.java)
        progressDialog = ProgressDialog(activity)

        response()
    }
    @SuppressLint("NotifyDataSetChanged")




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val  view:View=inflater.inflate(R.layout.hospital_fragment,container,false)
        binding=HospitalFragmentBinding.bind(view)
        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupLayout()
    }

    private  fun setupLayout(){
        manager= LinearLayoutManager(activity)
        layoutManager= LinearLayoutManager(activity)
        binding.recyclerView.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.setHasFixedSize(true)
    }



    @SuppressLint("NotifyDataSetChanged")
    fun response (){
        viewModel.hospitals.observe(this, Observer {
                hospitals->

            Log.e(TAG,"MVVM RESPONSE $hospitals")

            blogHospital.addAll(hospitals)

            adapter = HospitalAdapter(hospitals)
            adapter.notifyDataSetChanged()
            binding.recyclerView.adapter = adapter

        })
        viewModel.getHospitals()
    }

}


