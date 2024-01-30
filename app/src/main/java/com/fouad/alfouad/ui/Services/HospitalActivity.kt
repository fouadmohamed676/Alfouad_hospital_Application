package com.fouad.alfouad.ui.Services

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
import com.fouad.alfouad.Model.hospital.HospitalBojo
import com.fouad.alfouad.Network.Data
import com.fouad.alfouad.R
import com.fouad.alfouad.databinding.ActivityHospitalBinding
import org.json.JSONException
import org.json.JSONObject


class HospitalActivity :AppCompatActivity(R.layout.activity_hospital){
    lateinit var binding: ActivityHospitalBinding
    private lateinit var manager : RecyclerView.LayoutManager
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private  val hospitalList: ArrayList<com.fouad.alfouad.Response> = ArrayList()
    private lateinit var adapter: HospitalAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHospitalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupLayout()
//        getData()
//            data()
    }

private  fun setupLayout(){

    manager=LinearLayoutManager(this)
    layoutManager= LinearLayoutManager(this)
    binding.hospitalRecycler.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    binding.hospitalRecycler.layoutManager = layoutManager
    binding.hospitalRecycler.setHasFixedSize(true)
}

//    private  fun data(){
//        val quotesApi = RetrofitHelper.getInstance().create(ApiInterface::class.java)
//        // launching a new coroutine
//        GlobalScope.launch {
//            val result = quotesApi.getHospitals()
//            if (result != null)
//            // Checking the results
//                Log.d("result : ", result.toString())
//        }
//    }
    private fun getData() {
        val queue = Volley.newRequestQueue(this@HospitalActivity)
        val request: StringRequest =
            object :
                StringRequest(Request.Method.GET, Data.hospitalBojo,
                    Response.Listener<String?> { response ->
                        try {
                            Log.e("Response", response)

                            val jsonObject   = response?.let { JSONObject(it) }
                            val jsonArrayInfo = jsonObject?.getJSONArray("response")
                            val size: Int = jsonArrayInfo?.length()!!
                            Log.e("status","$jsonArrayInfo")

                            for (i in 0 until size) {
                                val jsonObjectDetails: JSONObject = jsonArrayInfo.getJSONObject(i)
//                                val hospital = Hospital(
//                                    jsonObjectDetails.getString("id"),
//                                    jsonObjectDetails.getString("dis"),
//                                    jsonObjectDetails.getString("address"),
//                                    jsonObjectDetails.getString("phone"),
//                                    jsonObjectDetails.getString("status"),
//                                    jsonObjectDetails.getString("local_id"),
//                                    jsonObjectDetails.getJSONObject("local_hospital"),
//                                    jsonObjectDetails.getJSONObject("hospitals"),
//                                )
//                                adapter = HospitalAdapter(this.applicationContext,hospitalList)
//                                binding.hospitalRecycler.adapter = adapter
//                                hospitalList.add(hospital)
                            }

                        } catch (e: JSONException) {
                            e.printStackTrace()
                        }
                    }, Response.ErrorListener { error ->
                        // displaying toast message on response failure.
                        Log.e("Error Response", "error is " + error!!.message)
                        Toast.makeText(this@HospitalActivity, "Fail to get data..", Toast.LENGTH_SHORT)
                            .show()
                    }){}

        queue.add(request)
        queue.cache
    }




}




