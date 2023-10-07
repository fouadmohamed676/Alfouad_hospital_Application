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
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(HospitalFragment())

            binding.bottomNavigationView.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.home_nav ->{

                        Log.e("","Home Fragment")
//                        bundle.putString("id", user_id)
//                        homeFragment.arguments = bundle
                        replaceFragment(HomeFragment())
                    }
                    R.id.hospital_nav ->{

                        Log.e("","hospital Fragment")
                        replaceFragment(HospitalFragment())
                    }
                    R.id.setting_nav ->{
                        Log.e("","Setting Fragment")
                        replaceFragment(SettingFragment())
                    }
                }
                true

        }
    }
    @SuppressLint("SuspiciousIndentation")
    private  fun replaceFragment(fragment: Fragment){

            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.frame_layout,fragment)
                fragmentTransaction.commit()

    }
}

