package com.fouad.alfouad.ui.Splash

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fouad.alfouad.R
import com.fouad.alfouad.databinding.ActivitySplashBinding
import com.fouad.alfouad.ui.Validate.MainActivity

@Suppress("DEPRECATION")
class SplashActivity :AppCompatActivity(R.layout.activity_splash) {
    lateinit var binding:ActivitySplashBinding
    lateinit var progressDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding= ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent=Intent(this,MainActivity::class.java)
        val progressDialog= ProgressDialog(this)
        progressDialog.setTitle("مرحباً بك..")
        progressDialog.setMessage("جاري التحميل")
//        progressDialog.show()
        progressDialog.setCancelable(false)

        startActivity(intent)
        finishAffinity()

    }
}