package com.fouad.alfouad.ui.Splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fouad.alfouad.Fragment.HomeFragment
import com.fouad.alfouad.Fragment.HospitalFragment
import com.fouad.alfouad.Fragment.SettingFragment
import com.fouad.alfouad.R
import com.fouad.alfouad.databinding.ActivityHomeBinding

@Suppress("DEPRECATION")
class HomeActivity : AppCompatActivity(R.layout.activity_home) {


    private lateinit var binding: ActivityHomeBinding
    private val homeFragment = HomeFragment()
    private val hospitalFragment = HospitalFragment()
    private val settingFragment = SettingFragment()
    var bundle = Bundle()
    private lateinit var phone: String
    private lateinit var userId: String
    private lateinit var email: String
    private lateinit var name: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        phone = intent.getStringExtra("phone").toString()
        userId = intent.getStringExtra("user_id").toString()
        email = intent.getStringExtra("email").toString()
        name = intent.getStringExtra("name").toString()
        Log.e("name HomeActivity",name).toString()
        replaceFragment(homeFragment)

        homeFragment.arguments = bundle
        bundle.putString("phone", phone)
        bundle.putString("user_id", userId).toString()
        bundle.putString("email", email).toString()
        bundle.putString("name", name).toString()
        binding.bottomNavigationView.setOnItemSelectedListener {

            settingFragment.arguments = bundle
            when (it.itemId) {
                R.id.home -> {
                    homeFragment.arguments = bundle
                    supportFragmentManager.beginTransaction()
                        .replace((R.id.frame_layout), homeFragment)
                        .commitNow()
                }

                R.id.hospital -> {

                    hospitalFragment.arguments = bundle
                    supportFragmentManager.beginTransaction()
                        .replace((R.id.frame_layout), hospitalFragment)
                        .commitNow()
                }

                R.id.setting -> {
                    settingFragment.arguments = bundle
                    supportFragmentManager.beginTransaction()
                        .replace((R.id.frame_layout), settingFragment)
                        .commitNow()
                }
            }
            true
        }
    }


    private fun replaceFragment(fragment: HomeFragment) {

        val transaction = supportFragmentManager.beginTransaction()
        settingFragment.arguments = bundle
        homeFragment.arguments = bundle
        hospitalFragment.arguments = bundle
        transaction.replace(R.id.frame_layout, fragment,phone)
        transaction.commit()
    }

    private var doubleBackToExitPressedOnce: Boolean = false

    @Suppress("OVERRIDE_DEPRECATION")
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            finish()
            finishAffinity()
            super.finish()
            return
        }
        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "إضغط مره اخرى للخروج", Toast.LENGTH_SHORT).show()
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            doubleBackToExitPressedOnce = false
        }, 2000)
    }

}



