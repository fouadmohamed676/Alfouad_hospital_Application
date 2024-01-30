package com.fouad.alfouad.ui.Splash
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.fouad.alfouad.Fragment.HomeFragment
import com.fouad.alfouad.Fragment.HospitalFragment
import com.fouad.alfouad.Fragment.SettingFragment
import com.fouad.alfouad.R

import com.fouad.alfouad.databinding.ActivityHomeBinding

class HomeActivity :AppCompatActivity(R.layout.activity_home){
    private lateinit var binding: ActivityHomeBinding
    private lateinit var userId:String
    private lateinit var email:String
    private lateinit var name:String
    private val settingFragment = SettingFragment()
    private val hospitalFragment = HospitalFragment()
    private val homeFragment = HomeFragment()
    val  bundle = Bundle()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userId = intent.getStringExtra("id").toString()
        email = intent.getStringExtra("email").toString()
        name = intent.getStringExtra("name").toString()

        replaceFragment(HomeFragment())
            binding.bottomNavigationView.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.home_nav ->{
                        replaceFragment(HomeFragment())
                        homeFragment.arguments = bundle
                        bundle.putString("id", userId)
                        bundle.putString("email", email)
                        bundle.putString("name", name)
                        Log.e("","Home Fragment homeActivity $userId")
                        replaceFragment(homeFragment)
                        supportFragmentManager.beginTransaction()
                        .replace((R.id.frame_layout),homeFragment)
                        .commitNow()
                    }
                    R.id.hospital_nav ->{
                        bundle.putString("id", userId)
                        bundle.putString("email", email)
                        bundle.putString("name", name)
                        Log.e("","hospital Fragment homeActivity $userId")
                        replaceFragment(HospitalFragment())
                        hospitalFragment.arguments = bundle
                        replaceFragment(hospitalFragment)
                        supportFragmentManager.beginTransaction()
                        .replace((R.id.frame_layout),hospitalFragment)
                        .commitNow()
                    }
                    R.id.setting_nav ->{
                        bundle.putString("id", userId)
                        bundle.putString("email", email)
                        bundle.putString("name", name)
                        Log.e("","SettingFragment homeActivity $userId")
                        replaceFragment(SettingFragment())
                        settingFragment.arguments = bundle
                        replaceFragment(settingFragment)
                        supportFragmentManager.beginTransaction()
                        .replace((R.id.frame_layout),settingFragment)
                        .commitNow()
                    }
                }
                true

        }
    }
    @SuppressLint("SuspiciousIndentation")
    private  fun replaceFragment(fragment: Fragment?=null){
        bundle.putString("id",userId)
        bundle.putString("email",email)
        bundle.putString("name",name)

        Log.e("replaceFragment ","value id :  $userId")
        Log.e("replaceFragment ","value email:  $email")
        Log.e("replaceFragment ","value name:  $name")
        if(fragment !=null) {
            bundle.putString("id",userId)
            bundle.putString("email",email)
            bundle.putString("name",name)
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frame_layout, fragment)
            fragmentTransaction.commit()
        }
    }
}

