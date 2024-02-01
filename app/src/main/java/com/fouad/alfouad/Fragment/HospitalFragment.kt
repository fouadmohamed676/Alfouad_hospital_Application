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
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fouad.alfouad.Adapter.HospitalAdapter
import com.fouad.alfouad.Response
import com.fouad.alfouad.R
import com.fouad.alfouad.ViewModel.HospitalViewModel
import com.fouad.alfouad.databinding.HospitalFragmentBinding
import com.fouad.alfouad.ui.Services.Details.HospitalDetailsActivity

const val EXTRA="EXTRA"
@Suppress("DEPRECATION")
class HospitalFragment:Fragment(R.layout.hospital_fragment) {

   private lateinit var binding: HospitalFragmentBinding
   lateinit var progressDialog:ProgressDialog
    private lateinit var manager : RecyclerView.LayoutManager
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var adapter: HospitalAdapter
    private lateinit var viewModel: HospitalViewModel
    private val blogHospital = mutableListOf<Response>()

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
        progressDialog.setTitle("Loading..")
        progressDialog.show()
        progressDialog.setCancelable(false)
        viewModel.hospitals.observe(this, Observer {
                hospitals->
            blogHospital.addAll(hospitals)

            adapter = HospitalAdapter(this.requireContext(),hospitals)
            adapter.notifyDataSetChanged()
            binding.recyclerView.adapter = adapter
//                object :HospitalAdapter.ItemClickListener{
//                override fun onItemClickListener(hospital: Response) {
//                    val intent = Intent(requireContext(), HospitalDetailsActivity::class.java)
//                    intent.putExtra(EXTRA,hospital)
//                    Log.e("hhhhhhhh","gg $hospitals")
//                    startActivity(intent)
//
//                }


        })

        viewModel.getHospitals()
        progressDialog.dismiss()
    }

}


