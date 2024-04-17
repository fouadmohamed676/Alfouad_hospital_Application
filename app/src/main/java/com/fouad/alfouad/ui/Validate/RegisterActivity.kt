@file:Suppress("DEPRECATION")

package com.fouad.alfouad.ui.Validate

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.fouad.alfouad.Model.create_pation.Blood
import com.fouad.alfouad.Model.create_pation.Local
import com.fouad.alfouad.Network.Data
import com.fouad.alfouad.R
import com.fouad.alfouad.ViewModel.PationViewModel
import com.fouad.alfouad.databinding.ActivityRegisterBinding
import com.fouad.alfouad.ui.Splash.HomeActivity
import org.json.JSONException
import org.json.JSONObject
import java.util.Calendar


@Suppress("DEPRECATION")
class RegisterActivity : AppCompatActivity(R.layout.activity_register) {
    lateinit var binding: ActivityRegisterBinding
    private lateinit var progressDialog: ProgressDialog
    private lateinit var viewModel: PationViewModel
    private lateinit var bloods: List<Blood>
    private lateinit var local: List<Local>

    private val calendar: Calendar = Calendar.getInstance()
    private val year_: Int = calendar.get(Calendar.YEAR)
    private val month_: Int = calendar.get(Calendar.MONTH)
    private val day_: Int = calendar.get(Calendar.DAY_OF_MONTH)

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(PationViewModel::class.java)

        progressDialog = ProgressDialog(this)
        binding.regDate.setOnClickListener {
            myDate()
        }
        binding.register.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            binding.regDate.text.toString()
            Log.e(TAG, "position selected  : " + binding.regDate.text.toString())

//            register()
            startActivity(intent)
        }

        bloods = listOf(
            Blood(8, "A+"),
            Blood(1, "A+"),
            Blood(4, "B+"),
            Blood(7, "O+"),
            Blood(9, "O-"),
            Blood(12, "B-")
        )
        local = listOf(
            Local(8, "الخرطوم"),
            Local(1, "جبل اولياء"),
            Local(4, "الخرطوم جنوب"),
            Local(7, "كرري"),
            Local(9, "شرق النيل"),
            Local(12, "ابوسعد")
        )
        bloodList()
        locals()


    }

    private fun bloodList() {
        binding.spinnerBlood.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            bloods
        )

        binding.spinnerBlood.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, positoin: Int, p3: Long) {
                Toast.makeText(
                    this@RegisterActivity,
                    "" + bloods[positoin].name,
                    Toast.LENGTH_SHORT
                ).show()
                Log.e(
                    TAG,
                    "position selected  : " + bloods[binding.spinnerBlood.selectedItemPosition].id
                )
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
    }

    private fun bloods() {
        viewModel.userBlood.observe(this) { dataList ->
            binding.spinnerBlood.adapter = ArrayAdapter(
                this,
                android.R.layout.simple_dropdown_item_1line,
                dataList
            )

            binding.spinnerBlood.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        p0: AdapterView<*>?,
                        view: View?,
                        positoin: Int,
                        p3: Long
                    ) {
                        Toast.makeText(
                            this@RegisterActivity,
                            "" + dataList[positoin],
                            Toast.LENGTH_SHORT
                        ).show()
                        Log.e(
                            TAG,
                            "position selected  : " + dataList[binding.spinnerBlood.selectedItemPosition]
                        )
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {

                    }
                }

            Log.e(TAG, dataList.toString())
        }
        viewModel.getBloods()
    }

    private fun locals() {
//        viewModel.userLocals.observe(this) {
//                dataList ->
        binding.spinnerLocals.adapter = ArrayAdapter(
            this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            local
        )
        Log.e(TAG, local.toString())

        binding.spinnerLocals.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, positoin: Int, p3: Long) {
                Toast.makeText(this@RegisterActivity, "" + local[positoin].name, Toast.LENGTH_SHORT)
                    .show()
                Log.e(
                    TAG,
                    "position selected  : " + local[binding.spinnerBlood.selectedItemPosition].id
                )
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }


//        }
//        viewModel.getLocals()
    }

    private fun nationalities() {
        viewModel.userNationality.observe(this) { dataList ->
            binding.spinnerLocals.adapter = ArrayAdapter(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                dataList
            )
            Log.e(TAG, dataList.toString())
        }
        viewModel.getNationalities()
    }

    private fun register() {
        starProgress()

        val email = binding.regEmail.text.toString()
        val phone = binding.regPhone.text.toString()
        val name = binding.regName.text.toString()
        val password = binding.regDate.text.toString()


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
                        if (opreation == "true") {
                            val intent = Intent(this, MainActivity::class.java)
                            Toast.makeText(this, "تم تسجيل الحساب", Toast.LENGTH_SHORT).show()
                            stopProgress()
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, "خطأ في التسجيل", Toast.LENGTH_SHORT).show()
                        }

                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                },
                Response.ErrorListener { volleyError ->
                    Toast.makeText(this, "الرجاء الاتصال بالشبكه", Toast.LENGTH_SHORT).show()
                    Log.e("StrResp", " No Internet Connection.. $volleyError")
                }) {
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


    @SuppressLint("SetTextI18n")
    fun myDate() {
        val datePickerDialog = DatePickerDialog(
            this,
            { view, year, month, day ->
                binding.regDate.setText("$year-" + 1.plus(month).toString() + "-$day")
                Log.e("date", "$year-" + 1.plus(month).toString() + "-$day")
            }, year_, month_, day_
        )
        datePickerDialog.setTitle("تاريخ الميلاد")
        datePickerDialog.show()
    }


}