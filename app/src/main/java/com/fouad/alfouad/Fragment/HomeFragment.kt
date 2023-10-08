@file:Suppress("DEPRECATION")

package com.fouad.alfouad.Fragment

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fouad.alfouad.R
import com.fouad.alfouad.databinding.HomeFragmentBinding
import com.fouad.alfouad.ui.Services.ClinkActivity
import com.fouad.alfouad.ui.Services.PharmacyActivity

@Suppress("DEPRECATION")
class HomeFragment:Fragment(R.layout.home_fragment) {

   private lateinit var binding: HomeFragmentBinding
   lateinit var progressDialog:ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=HomeFragmentBinding.inflate(layoutInflater)
        progressDialog = ProgressDialog(activity)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val  view:View=inflater.inflate(R.layout.home_fragment,container,false)
        binding=HomeFragmentBinding.bind(view)


        binding.clink.setOnClickListener {

            val intentClink=Intent(view.context,ClinkActivity::class.java)
            startActivity(intentClink)

        }
        binding.pharmBtn.setOnClickListener{
            val intent=Intent(view.context,PharmacyActivity::class.java)
            startActivity(intent)
        }
        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
     Log.e("","")
       }

}