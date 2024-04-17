package com.fouad.alfouad.ui.Splash

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.fouad.alfouad.Network.Data
import com.fouad.alfouad.R
import com.fouad.alfouad.databinding.ActivitySplashBinding
import com.fouad.alfouad.ui.Validate.MainActivity
import org.json.JSONException


@Suppress("DEPRECATION")
@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity(R.layout.activity_splash) {
    lateinit var binding: ActivitySplashBinding
    private lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        progressBar = ProgressBar(this)
        progressBar.visibility.toShort()

//        getData()
        successConn()

    }


    private fun getData() {
        val queue = Volley.newRequestQueue(this)
        val request: StringRequest = object : StringRequest(Request.Method.GET,
            Data.Base_Url_Api + "bestDoctors",
            Response.Listener<String> { response ->
                try {
                    successConn()
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            Response.ErrorListener { volleyError ->
                logoutDialog()
                Log.e("Response", " No Internet Connection.. $volleyError")
            }) {}
        queue.add(request)
    }

    private fun logoutDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setCancelable(false)
        builder.setTitle("لايوجد اتصال انترنت")
        builder.setIcon(R.drawable.ic_wifi)
        builder.setView(R.layout.connection_item)
        val alertDialog = builder.create()
        alertDialog.setButton(Dialog.BUTTON_POSITIVE, "خروج") { view, data ->

            finish()
        }
        alertDialog.setButton(Dialog.BUTTON_NEGATIVE, "إلغاء") { dialog, _ ->
//            dialog.dismiss()
            mainActivity()
        }
        alertDialog.show()
    }


    private fun successConn() {
        val intent = Intent(this, MainActivity::class.java)
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(intent)
            finishAffinity()
        }, 2000)

    }

    private fun mainActivity() {
        val mainActivity = Intent(this, MainActivity::class.java)
        startActivity(mainActivity)
    }

}