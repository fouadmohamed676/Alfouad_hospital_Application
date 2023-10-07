package com.fouad.alfouad.ui.Services

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.fouad.alfouad.R
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.fouad.alfouad.Adapter.ClinkAdapter
import com.fouad.alfouad.Clinck
import com.fouad.alfouad.Network.Data
import com.fouad.alfouad.databinding.ActivityClinksBinding
import org.json.JSONException
import org.json.JSONObject

class ClinkActivity : AppCompatActivity(R.layout.activity_clinks) {
    private lateinit var binding:ActivityClinksBinding
    private lateinit var manager :RecyclerView.LayoutManager

    private lateinit var layoutManager: RecyclerView.LayoutManager
    private  val clinkList: ArrayList<Clinck> = ArrayList()
    private lateinit var adapter: ClinkAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityClinksBinding.inflate(layoutInflater)
        setContentView(binding.root)
        manager=LinearLayoutManager(this)
        layoutManager=LinearLayoutManager(this)
        binding.recycleClinks.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.recycleClinks.layoutManager = layoutManager
        binding.recycleClinks.setHasFixedSize(true)
        getData()

    }



    private fun getData() {
        val queue = Volley.newRequestQueue(this@ClinkActivity)
        val request: StringRequest =
            object :
                StringRequest(Request.Method.GET, Data.show_clink,
                    Response.Listener<String?> { response ->
                        try {
                            Log.e("Response", response)
                            val jsonObject   = response?.let { JSONObject(it) }
                            val jsonArrayInfo = jsonObject?.getJSONArray("response")
                            val size: Int = jsonArrayInfo?.length()!!

                            for (i in 0 until size) {
                                val jsonObjectDetails: JSONObject = jsonArrayInfo.getJSONObject(i)
                                val clink = Clinck(
                                    jsonObjectDetails.getString("id"),
                                    jsonObjectDetails.getString("local_id"),
                                    jsonObjectDetails.getString("name"),
                                    jsonObjectDetails.getString("phone"),
                                    jsonObjectDetails.getString("status"),
                                    jsonObjectDetails.getJSONObject("local"),
                                )
                                adapter = ClinkAdapter(clinkList)
                                binding.recycleClinks.adapter = adapter
                                clinkList.add(clink)

                            }

                        } catch (e: JSONException) {
                            e.printStackTrace()
                        }
                    }, Response.ErrorListener { error ->
                        // displaying toast message on response failure.
                        Log.e("Error Response", "error is " + error!!.message)
                        Toast.makeText(this@ClinkActivity, "Fail to get data..", Toast.LENGTH_SHORT)
                            .show()
                    }){}

        queue.add(request)
        queue.cache
    }




}