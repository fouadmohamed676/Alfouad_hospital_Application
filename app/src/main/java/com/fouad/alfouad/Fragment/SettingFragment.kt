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
import com.fouad.alfouad.databinding.SettingFragmentBinding
import com.fouad.alfouad.ui.Services.DoctorInterView

@Suppress("DEPRECATION")
class SettingFragment:Fragment(R.layout.setting_fragment) {

    private lateinit var binding: SettingFragmentBinding
    lateinit var progressDialog:ProgressDialog
    private  lateinit var userId:String
    private  lateinit var email:String
    private  lateinit var name:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=SettingFragmentBinding.inflate(layoutInflater)

        userId = arguments?.getString("id").toString()
        email = arguments?.getString("email").toString()
        name = arguments?.getString("name").toString()


        binding.nameSetting.text=email
        binding.email.text=name

        progressDialog = ProgressDialog(activity)

            Log.e("setting_fragment onCreate","name : $name")
            Log.e("setting_fragment onCreate","email : $email")
            Log.e("setting_fragment onCreate","id : $userId")

         binding.myInterViews.setOnClickListener {
            val intent = Intent(activity,DoctorInterView::class.java)
            intent.putExtra("id", userId)
            startActivity(intent)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val  view:View=inflater.inflate(R.layout.setting_fragment,container,false)
        binding=SettingFragmentBinding.bind(view)

        Log.e("onCreateView","name : $name ")
        Log.e("onCreateView","email : $email ")
        Log.e("onCreateView","id : $userId ")


        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

      }





}