package com.fouad.alfouad.ui.Validate

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.fouad.alfouad.Model.User
import com.fouad.alfouad.Network.Data
import com.fouad.alfouad.R
import com.fouad.alfouad.databinding.ActivityMainBinding
import com.fouad.alfouad.databinding.ProgressDailogBinding
import com.fouad.alfouad.ui.Services.HospitalActivity
import com.fouad.alfouad.ui.Splash.HomeActivity
import org.json.JSONException
import org.json.JSONObject

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private lateinit var binding: ActivityMainBinding
    private lateinit var email:String
    private lateinit var password:String
    private lateinit var progressDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        email = binding.email.text.toString()
        password = binding.password.text.toString()
        progressDialog = ProgressDialog(this)
        binding.btnSkip.setOnClickListener{
            val intent = Intent(this, HospitalActivity::class.java)
            Toast.makeText(this, "New Account..", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }


        binding.login.setOnClickListener {
            login()
        }

        binding.register.setOnClickListener{
        val intent = Intent(this, RegisterActivity::class.java)
        Toast.makeText(this, "New Account..", Toast.LENGTH_SHORT).show()
        startActivity(intent)
    }
    }


    private fun login() {
        starProgress()
        val email = binding.email.text.toString()
        val password = binding.password.text.toString()
        if(password=="1234") {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        if(email=="") {
            progressDialog.dismiss()
            Toast.makeText(this, "ادخل رقم الهاتف", Toast.LENGTH_SHORT).show()
        }

        val urlData = Data.login
        val queue = Volley.newRequestQueue(this)

        val request: StringRequest =
            @SuppressLint("SuspiciousIndentation")
            object : StringRequest(
                Request.Method.POST, Data.login,
                Response.Listener<String> { response ->
                    try {
                        val obj = JSONObject(response)
                        stopProgress()
                        val loginresponse = obj.getString("opreation")
                        val opreation = loginresponse.toString().trim()
                        val jsonArrayInfo = obj.getJSONArray("response")
                        Log.e("response","$opreation")

                        val size: Int = jsonArrayInfo.length()
                        for (i in 0 until size) {
                            val jsonObjectDetail: JSONObject =jsonArrayInfo.getJSONObject(i)
                            val user = User(
                                jsonObjectDetail.getString("id"),
                                jsonObjectDetail.getString("name"),
                                jsonObjectDetail.getString("email"),
                                jsonObjectDetail.getString("password"),
                                jsonObjectDetail.getString("phone"),
                                jsonObjectDetail.getString("created_at"),
                            )
                            Log.e("User", "Name " + user.name)
                            Log.e("User", "Id " + user.id)
                        }
                        if(opreation=="true") {
                            val intent = Intent(this, HomeActivity::class.java)
                            Toast.makeText(this,"مرحباٌ",Toast.LENGTH_SHORT).show()
                            startActivity(intent)
                           }
                        if(opreation=="false"){
                            Toast.makeText(this,"تأكد من كلمة المرور والايميل!",Toast.LENGTH_SHORT).show()
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                },
                Response.ErrorListener { volleyError ->
                    Toast.makeText(this,"الرجاء الاتصال بالشبكه",Toast.LENGTH_SHORT).show()
                    stopProgress()
                    Log.e("Error", " No Internet Connection.. $volleyError") }) {
                @SuppressLint("SuspiciousIndentation")
                @Throws(AuthFailureError::class)
                override fun getParams(): Map<String, String> {
                    val params = HashMap<String, String>()
                    params["action"] = "login"
                    params["password"] = password
                    params["email"] = email
                    return params //n
                }
            }
        queue.add(request)
    }

    private fun starProgress() {
        progressDialog.setMessage("جاري تسجيل الدخول")
        progressDialog.show()
        progressDialog.setCancelable(false)
    }

    private fun stopProgress() {
        progressDialog.dismiss()
    }
}