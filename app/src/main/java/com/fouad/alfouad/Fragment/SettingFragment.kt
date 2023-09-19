package com.fouad.alfouad.Fragment

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fouad.alfouad.R
import com.fouad.alfouad.databinding.SettingFragmentBinding

@Suppress("DEPRECATION")
class SettingFragment:Fragment(R.layout.setting_fragment) {

   private lateinit var binding: SettingFragmentBinding
   lateinit var progressDialog:ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=SettingFragmentBinding.inflate(layoutInflater)

        progressDialog = ProgressDialog(activity)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val  view:View=inflater.inflate(R.layout.setting_fragment,container,false)
        binding=SettingFragmentBinding.bind(view)

        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //binding.recycle.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
    }




}