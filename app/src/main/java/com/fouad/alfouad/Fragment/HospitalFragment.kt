@file:Suppress("DEPRECATION")

package com.fouad.alfouad.Fragment

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fouad.alfouad.R
import com.fouad.alfouad.databinding.HospitalFragmentBinding
@Suppress("DEPRECATION")
class HospitalFragment:Fragment(R.layout.hospital_fragment) {

   private lateinit var binding: HospitalFragmentBinding
   lateinit var progressDialog:ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=HospitalFragmentBinding.inflate(layoutInflater)

        progressDialog = ProgressDialog(activity)
    }

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
        //binding.recycle.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
    }




}