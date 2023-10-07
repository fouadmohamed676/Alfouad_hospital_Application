package com.fouad.alfouad.ui.Validate

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.fouad.alfouad.Model.User
import com.fouad.alfouad.Network.Data
import com.fouad.alfouad.R
import com.fouad.alfouad.databinding.ActivityRegisterBinding
import com.fouad.alfouad.ui.Splash.HomeActivity
import org.json.JSONException
import org.json.JSONObject

@Suppress("DEPRECATION")
class RegisterActivity :AppCompatActivity(R.layout.activity_register) {
    lateinit var binding: ActivityRegisterBinding
    private lateinit var progressDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        progressDialog = ProgressDialog(this)
        binding.register.setOnClickListener{
            val intent=Intent(this, HomeActivity::class.java)
            register()
            startActivity(intent)
        }
    }

    private fun register() {
        starProgress()

        val email = binding.regEmail.text.toString()
        val phone = binding.regPhone.text.toString()
        val name = binding.regName.text.toString()
        val password = binding.regPassword.text.toString()


        val urlData = Data.register
        val queue = Volley.newRequestQueue(this)

        val request: StringRequest =
            @SuppressLint("SuspiciousIndentation")
            object : StringRequest(
                Request.Method.POST, urlData,
                Response.Listener<String> { response ->
                    try {
                        val obj = JSONObject(response)
                        val loginresponse = obj.getString("opreation")
                        val opreation = loginresponse.toString().trim()
                        Log.e("opreation", opreation)
                        if(opreation=="true") {
                            val intent = Intent(this, MainActivity::class.java)
                            Toast.makeText(this,"تم تسجيل الحساب",Toast.LENGTH_SHORT).show()
                            stopProgress()
                            startActivity(intent)
                            }else{
                            Toast.makeText(this,"خطأ في التسجيل",Toast.LENGTH_SHORT).show()
                        }

                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                },
                Response.ErrorListener { volleyError ->
                    Toast.makeText(this,"الرجاء الاتصال بالشبكه", Toast.LENGTH_SHORT).show()
                    Log.e("StrResp", " No Internet Connection.. $volleyError") }) {
                @SuppressLint("SuspiciousIndentation")
                @Throws(AuthFailureError::class)
                override fun getParams(): Map<String, String> {
                    val params = HashMap<String, String>()
                    params.put("action", "register")
                    params.put("phone", phone)
                    params.put("email", email)
                    params.put("name", name)
                    params.put("password", password)
                    return params
                }
            }
        queue.add(request)
    }


    private fun starProgress() {
        progressDialog.setMessage("جاري تسجيل الحساب")
        progressDialog.show()
        progressDialog.setCancelable(false)
    }

    private fun stopProgress() {
        progressDialog.dismiss()
    }

}