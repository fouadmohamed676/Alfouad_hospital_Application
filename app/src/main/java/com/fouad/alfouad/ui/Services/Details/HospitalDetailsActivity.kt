package com.fouad.alfouad.ui.Services.Details

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.fouad.alfouad.Adapter.HospitalAdapter
import com.fouad.alfouad.Adapter.HospitalDetailsAdapter
import com.fouad.alfouad.Hospital
import com.fouad.alfouad.Model.HospitalDetailsModel
import com.fouad.alfouad.Network.Data
import com.fouad.alfouad.R
import com.fouad.alfouad.databinding.ActicivtyDetailsHospitalBinding
import com.fouad.alfouad.databinding.ActivityHospitalBinding
import org.json.JSONException
import org.json.JSONObject

class HospitalDetailsActivity :AppCompatActivity(R.layout.acticivty_details_hospital){
    private lateinit var binding: ActicivtyDetailsHospitalBinding

    private  val hospitalList: ArrayList<HospitalDetailsModel> = ArrayList()
    private lateinit var adapter: HospitalDetailsAdapter
    private lateinit var manager : RecyclerView.LayoutManager
    private lateinit var layoutManager: RecyclerView.LayoutManager

    private lateinit var id:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActicivtyDetailsHospitalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupLayout()
         id = intent.getStringExtra("id").toString()
         Log.e("id on create",id)
        getData()
    }
    private  fun setupLayout(){
        manager= LinearLayoutManager(this)
        layoutManager= LinearLayoutManager(this)
        binding.hospitalDetails.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.hospitalDetails.layoutManager = layoutManager
        binding.hospitalDetails.setHasFixedSize(true)
    }

    private fun getData() {
        val queue = Volley.newRequestQueue(this)
        val request: StringRequest =
            @SuppressLint("SuspiciousIndentation")
            object : StringRequest(
                Request.Method.GET, Data.hospital_doctors+id,
                Response.Listener<String> { response ->
                    try {
                        val obj = JSONObject(response)
                        val jsonArrayInfo = obj.getJSONArray("response")
                        Log.e("response","$jsonArrayInfo")
                        val size: Int = jsonArrayInfo.length()
                        for (i in 0 until size) {
                            val jsonObjectDetails: JSONObject = jsonArrayInfo.getJSONObject(i)
                            val hospitalDetails = HospitalDetailsModel(
                                jsonObjectDetails.getJSONObject("doctors"),
                                jsonObjectDetails.getString("id"),
                            )

                            adapter = HospitalDetailsAdapter(hospitalList)
                            binding.hospitalDetails.adapter = adapter
                            hospitalList.add(hospitalDetails)
                        }


                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                },
                Response.ErrorListener { volleyError ->
                    Toast.makeText(this,"الرجاء الاتصال بالشبكه",Toast.LENGTH_SHORT).show()
                    Log.e("Error", " No Internet Connection.. $volleyError") }) {

            }
        queue.add(request)
    }

}