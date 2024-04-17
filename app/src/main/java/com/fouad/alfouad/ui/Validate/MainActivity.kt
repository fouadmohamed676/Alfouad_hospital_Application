package com.fouad.alfouad.ui.Validate

import android.app.ProgressDialog
import android.content.ContentValues.TAG
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fouad.alfouad.R
import com.fouad.alfouad.ViewModel.UserViewModel
import com.fouad.alfouad.databinding.ActivityMainBinding
import com.fouad.alfouad.ui.Splash.HomeActivity

@Suppress("DEPRECATION", "UNREACHABLE_CODE")
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private lateinit var binding: ActivityMainBinding
//    private lateinit var email:String
    private lateinit var userId:String
    private lateinit var name:String
    private lateinit var progressDialog: ProgressDialog
    private lateinit var userViewModel: UserViewModel
    private lateinit var phone:String
    private  var logResponse:String = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userViewModel=ViewModelProvider(this).get(UserViewModel::class.java)
        logResponse=intent.getStringExtra("logout").toString()
        progressDialog = ProgressDialog(this)
//        login()
        if (logResponse=="1"){
        clearPreferences()
        }

        showUserPreferences()

        val intent = Intent(this, HomeActivity::class.java)
        binding.login.setOnClickListener {


            if (binding.phone.text.toString().isNullOrEmpty()){
                binding.phone.error = "Oops.."
                binding.phone.requestFocus()
            }else {
                starProgress()
                login()
            }
        }


        if (binding.phone.text.toString().isNotBlank()){
            intent.putExtra("phone",binding.phone.text.toString())
            startActivity(intent)
        }

        binding.register.setOnClickListener{
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

        binding.btnSkip.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

    }

    private  fun login(){
        userViewModel.userData.observe(this, Observer {
            response->
//            Log.e(TAG,"response phone : index ${response.get(0).phone}")
//            Log.e(TAG,"response name : index ${response.get(0).name}")
//            Log.e(TAG,"response email : index ${response.get(0).email}")
//            Log.e(TAG,"response date : index ${response.get(0).barth_date}")
//            Log.e(TAG,"response id : index ${response.get(0).id}")

           val my_phone = response[0].phone
            saveUserPreferences(my_phone)
            val home = Intent(this, HomeActivity::class.java)
            home.putExtra("phone", phone)
            home.putExtra("user_id", response[0].id.toString())
            home.putExtra("name", response[0].name)
            home.putExtra("email", response[0].email)
            startActivity(home)
        })

        phone = binding.phone.text.toString().trim()
        userViewModel.getUser(phone)
    }



    private var doubleBackToExitPressedOnce = false

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
        Handler(Looper.getMainLooper()).postDelayed(Runnable { doubleBackToExitPressedOnce = false }, 2000)
    }


    private fun saveUserPreferences(myPhone : String){
        val sharedPreferences : SharedPreferences = getSharedPreferences("phone", MODE_PRIVATE)
        val savePhone : SharedPreferences.Editor = sharedPreferences.edit()
        savePhone.putString("phone",myPhone).apply()
    }
    private fun showUserPreferences(){
        val sharedPreferences : SharedPreferences = getSharedPreferences("phone", MODE_PRIVATE)
        val txt : String? = sharedPreferences.getString("phone","")
        binding.phone.setText(txt.toString().trim())
    }

    private fun clearPreferences() {
        val setting :SharedPreferences = getSharedPreferences("phone", MODE_PRIVATE)
        val editor: SharedPreferences.Editor = setting.edit()
        editor.remove("phone")
        editor.clear()
        editor.apply()
    }

    private fun starProgress() {
        progressDialog.setMessage("جاري تسجيل الدخول")
        progressDialog.show()
        progressDialog.setCancelable(true)
    }

    private fun stopProgress() {
        progressDialog.dismiss()
    }

}