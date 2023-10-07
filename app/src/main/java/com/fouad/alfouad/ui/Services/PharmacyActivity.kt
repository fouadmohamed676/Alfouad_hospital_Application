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
import com.fouad.alfouad.Adapter.PharmacyAdapter
import com.fouad.alfouad.Network.Data
import com.fouad.alfouad.Pharmacy
import com.fouad.alfouad.R
import com.fouad.alfouad.databinding.ActivityPharmacyBinding
import org.json.JSONException
import org.json.JSONObject

class PharmacyActivity :AppCompatActivity(R.layout.activity_pharmacy) {
    private lateinit var binding: ActivityPharmacyBinding
    private lateinit var manager : RecyclerView.LayoutManager

    private lateinit var layoutManager: RecyclerView.LayoutManager
    private  val clinkList: ArrayList<Pharmacy> = ArrayList()
    private lateinit var adapter: PharmacyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPharmacyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        manager= LinearLayoutManager(this)
        layoutManager= LinearLayoutManager(this)
        binding.recyclePharmacy.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.recyclePharmacy.layoutManager = layoutManager
        binding.recyclePharmacy.setHasFixedSize(true)

        getData()
    }


    private fun getData() {
        val queue = Volley.newRequestQueue(this@PharmacyActivity)
        val request: StringRequest =
            object :
                StringRequest(Request.Method.GET, Data.show_pharmacy,
                    Response.Listener<String?> { response ->
                        try {
                            Log.e("Response", response)
                            val jsonObject   = response?.let { JSONObject(it) }
                            val jsonArrayInfo = jsonObject?.getJSONArray("data")
                            val size: Int = jsonArrayInfo?.length()!!

                            Log.e("Success", "Response jsonArrayInfo: $jsonArrayInfo")


                            for (i in 0 until size) {
                                val jsonObjectDetails: JSONObject = jsonArrayInfo.getJSONObject(i)
                                val pharmacy = Pharmacy(
                                    jsonObjectDetails.getString("id"),
                                    jsonObjectDetails.getString("name"),
                                    jsonObjectDetails.getString("title"),
                                    jsonObjectDetails.getString("phone"),
                                    jsonObjectDetails.getString("status"),
                                    jsonObjectDetails.getString("time_work"),
                                )
                                adapter = PharmacyAdapter(clinkList)
                                binding.recyclePharmacy.adapter = adapter
                                clinkList.add(pharmacy)

                            }

                        } catch (e: JSONException) {
                            e.printStackTrace()
                        }
                    }, Response.ErrorListener { error ->
                        // displaying toast message on response failure.
                        Log.e("Error Response", "error is " + error!!.message)
                        Toast.makeText(this@PharmacyActivity, "Fail to get data..", Toast.LENGTH_SHORT)
                            .show()
                    }){}

        queue.add(request)
        queue.cache
    }

}