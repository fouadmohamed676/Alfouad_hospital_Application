package com.fouad.alfouad.ui.Validate

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.fouad.alfouad.Model.User
import com.fouad.alfouad.Network.ApiInterface
import com.fouad.alfouad.Network.RetrofitHelper
import com.fouad.alfouad.R
import com.fouad.alfouad.databinding.ActivityMainBinding
import com.fouad.alfouad.ui.Services.HospitalActivity
import com.fouad.alfouad.ui.Splash.HomeActivity
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    lateinit var binding: ActivityMainBinding
    lateinit var email:String
    lateinit var password:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        email = binding.password.text.toString()
        binding.btnSkip.setOnClickListener{
            val intent = Intent(this, HospitalActivity::class.java)
            Toast.makeText(this, "New Account..", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
        binding.login.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            Toast.makeText(this, "welcome..", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
        binding.register.setOnClickListener{
        val intent = Intent(this, RegisterActivity::class.java)
        Toast.makeText(this, "New Account..", Toast.LENGTH_SHORT).show()
        startActivity(intent)
    }
        get_data()
    }


    private fun get_data() {

        val urlUser = "https://192.168.137.1/apis/users.php"
        val queue = Volley.newRequestQueue(this)
        Log.e("","user url $urlUser")
        val request: StringRequest =
            @SuppressLint("SetTextI18n")
            object : StringRequest(
                Request.Method.POST, urlUser,
                Response.Listener<String> { response ->
                    try {

                        Log.e("","user point try")

                        val obj = JSONObject(response)
//                        stpProgress()
                        val loginresponse = obj.getString("data")
                        val point = loginresponse
                        Log.e("","user point $point")
                    } catch (e: JSONException) {

                        Log.e("catch"," ------ catch ${e.localizedMessage}")
                        e.printStackTrace()
                    }
                },
                Response.ErrorListener {

                    Log.e("error Response","error : 403 ")
                }) {

                @SuppressLint("SuspiciousIndentation")

                @Throws(AuthFailureError::class)
                override fun getParams(): Map<String, String> {
                    val params = HashMap<String, String>()
                    params.put("id", "1")
                    return params
                }
            }
        queue.add(request)
    }


    private fun getHospitals() {
        val url="https://192.168.43.114/Project_Api/get_orders.php"
//        val url="https://tandtsa.com/tandt/show/adds_list.php"
//        val queue = newRequestQueue(this)

        Log.e("response : -- ","Vooooooolly")
        val request: StringRequest =
            object : StringRequest(
                Method.GET,url
               , Response.Listener<String?> { response ->
                    try {

                        Log.e("response : - ","try..")
                        val jsonContact = JSONObject(response)
                        val jsonArrayInfo = jsonContact.getJSONArray("data")

                         Log.e("response : ","$jsonArrayInfo")


                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }, Response.ErrorListener {
                    // Error message on response failure.
                    Log.e("Connection", "No Internet Connection..$url")
                }) {
            }
//        queue.add(request)
    }
    private fun user__Points() {


        val url="http://127.0.0.1:8000/api/doctors/show"
//        val queue = newRequestQueue(this.applicationContext)

        Log.e("Connection", "try Internet ..$url")
        val request: StringRequest =
            @SuppressLint("SetTextI18n")
            object : StringRequest(
                Method.GET, url,
                Response.Listener { response ->
                    try {

                        Log.e("Connection", "try Internet Connection..$url")
                        val obj = JSONObject(response)
                        val jsonObjectDetails = obj.getJSONArray("data")

                        Log.e("Connection", "try Internet Connection..$jsonObjectDetails")
//                        val point: Int = jsonObjectDetails
//                        userPoints=point.toString()
//                        Log.e("","userrrrrrrrrrrrr point $userPoints")
//                        binding.pointsAucation.text = point.toString()
                    } catch (e: JSONException) {
                        e.printStackTrace()
                        Log.e("Connection", "try .")
                    }
                },
                Response.ErrorListener { }) {
//                @SuppressLint("SuspiciousIndentation")
//                @Throws(AuthFailureError::class)
//                override fun getParams(): Map<String, String> {
//                    val params = HashMap<String, String>()
//                    params.put("id", "1")
//                    return params
//                }
            }
//        queue.add(request)
    }
     fun get_data_(){

        Log.e("response : -- ","Getdata")
        val quotesApi = RetrofitHelper.getInstance().create(ApiInterface::class.java)
        // launching a new coroutine
//        val result = quotesApi.getuser()

//        Log.d("response: ", result.toString())
//        GlobalScope.launch {
//            Log.e("response : -- ","GlobalScope--")
//            val result = quotesApi.getuser()
//            Log.d("response: ", result.toString())
//        }


    }
    private fun log_(){
        if (email.trimEnd() == "1234") {
            val intent = Intent(this, HomeActivity::class.java)
            Toast.makeText(this, "welcome..", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
    }
    private fun login() {
//        progress()

         email = binding.email.text.toString()
         password = binding.password.text.toString()
        if(email=="f@gmail.com") {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        if(email=="") {
//            progressDialog.dismiss()
//            Toast.makeText(this, "ادخل رقم الهاتف", Toast.LENGTH_SHORT).show()
        }
//            http://192.168.43.103/Project_Api/login.php
        val urlData = "http://192.168.43.114/apis/users.php"
//        val urlData = Data.show_user

        val request: StringRequest =
            @SuppressLint("SuspiciousIndentation")
            object : StringRequest(Request.Method.POST, urlData,
                Response.Listener<String> { response ->
                    try {
                        val obj = JSONObject(response)
                        Log.e("DATA---", " DATA.. $obj")

//                        stpProgress()
                        val loginresponse = obj.getString("response")
                        val StrResp = loginresponse.toString().trim()

                        val jsonObjectDetail: JSONObject = obj.getJSONObject("data")
                        val user = User(
                            jsonObjectDetail.getString("id"),
                            jsonObjectDetail.getString("name"),
                            jsonObjectDetail.getString("phone"),
                            jsonObjectDetail.getString("email"),
                            jsonObjectDetail.getString("password"),
                        )
                        Log.e("User", "User Name-- " + user.name)
                        Log.e("User", "User Id-- " + user.id)
                        Log.e("User", "phone phone-- " + user.phone)

                        if(StrResp=="true") {
//                            saveUserIdPreferences(user.id)
                            val intent = Intent(this, HomeActivity::class.java)
//                            checkUserIsLogin(user.name,user.phone,user.contact)
                            password =""
                            startActivity(intent)
                            Toast.makeText(this,"مرحباٌ",Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this,"خطأ في رقم الهاتف",Toast.LENGTH_SHORT).show()
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                },
                Response.ErrorListener {
                        volleyError ->
                    Toast.makeText(this,"الرجاء الاتصال بالشبكة",Toast.LENGTH_SHORT).show()
                    Log.e("StrResp", " No Internet Connection.. $volleyError")
                })
            {
//                @SuppressLint("SuspiciousIndentation")
//                @Throws(AuthFailureError::class)
//                override fun getParams(): Map<String, String> {
//                    val params = HashMap<String, String>()
////                    params.put("action", "login")
////                    params.put("email", email)
////                    params.put("password", password)
//                    return params
//                }
            }
//        queue.add(request)
    }

}