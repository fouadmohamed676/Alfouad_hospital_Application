package com.fouad.alfouad.ui.Splash
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.fouad.alfouad.Fragment.HomeFragment
import com.fouad.alfouad.Fragment.HospitalFragment
import com.fouad.alfouad.Fragment.SettingFragment
import com.fouad.alfouad.R

import com.fouad.alfouad.databinding.ActivityHomeBinding
import com.fouad.alfouad.databinding.HomeFragmentBinding

class HomeActivity :AppCompatActivity(R.layout.activity_home){
    lateinit var binding: ActivityHomeBinding
    private  var homeFragment=HomeFragment()
    private  var settingFragment= SettingFragment()
    private  var hospitalFragment= HospitalFragment()
    var  bundle = Bundle()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(homeFragment)

            binding.bottomNavigationView.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.home_nav ->{
//                        bundle.putString("id", user_id)
                        homeFragment.arguments = bundle
                        replaceFragment(homeFragment)
                        supportFragmentManager.beginTransaction()
                            .replace((R.id.frame_layout),homeFragment)
                            .commitNow()
                    }
                    R.id.auction_nav ->{
//                        bundle.putString("id", user_id)
                        hospitalFragment.arguments = bundle
                        replaceFragment(hospitalFragment)
                        supportFragmentManager.beginTransaction()
                            .replace((R.id.frame_layout),hospitalFragment)
                            .commitNow()
                    }
                    R.id.setting_nav ->{
//                        bundle.putString("id", user_id)
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
    private  fun replaceFragment(fragment: Fragment? = null){
//        bundle.putString("id",user_id)
        if(fragment !=null){
//            bundle.putString("id",user_id)
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout,fragment)
            transaction.commit()
        }
    }
}

