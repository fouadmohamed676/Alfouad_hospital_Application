@file:Suppress("DEPRECATION")

package com.fouad.alfouad.Fragment

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.fouad.alfouad.Adapter.HospitalAdapter
import com.fouad.alfouad.Hospital
import com.fouad.alfouad.Network.Data
import com.fouad.alfouad.R
import com.fouad.alfouad.databinding.HospitalFragmentBinding
import org.json.JSONException
import org.json.JSONObject

@Suppress("DEPRECATION")
class HospitalFragment:Fragment(R.layout.hospital_fragment) {

   private lateinit var binding: HospitalFragmentBinding
   lateinit var progressDialog:ProgressDialog
    private lateinit var manager : RecyclerView.LayoutManager
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private  val hospitalList: ArrayList<Hospital> = ArrayList()
    private lateinit var adapter: HospitalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=HospitalFragmentBinding.inflate(layoutInflater)

        progressDialog = ProgressDialog(activity)
        Log.e("","onCreate")
        getData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val  view:View=inflater.inflate(R.layout.hospital_fragment,container,false)
        binding=HospitalFragmentBinding.bind(view)
        Log.e("","onCreateView")
        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("","onActivityCreated")
        setupLayout()
//        binding.recyclerView.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
    }

    private  fun setupLayout(){

        manager= LinearLayoutManager(activity)
        layoutManager= LinearLayoutManager(activity)
        binding.recyclerView.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.setHasFixedSize(true)
    }
    private fun getData() {
        val queue = Volley.newRequestQueue(this.context)
        val request: StringRequest =
            object :
                StringRequest(Request.Method.GET, Data.show_hospital,
                    Response.Listener<String?> { response ->
                        try {
                            Log.e("Response", response)

                            val jsonObject   = response?.let { JSONObject(it) }
                            val jsonArrayInfo = jsonObject?.getJSONArray("response")
                            val size: Int = jsonArrayInfo?.length()!!
                            Log.e("status","$jsonArrayInfo")

                            for (i in 0 until size) {
                                val jsonObjectDetails: JSONObject = jsonArrayInfo.getJSONObject(i)
                                val hospital = Hospital(
                                    jsonObjectDetails.getString("id"),
                                    jsonObjectDetails.getString("dis"),
                                    jsonObjectDetails.getString("address"),
                                    jsonObjectDetails.getString("phone"),
                                    jsonObjectDetails.getString("status"),
                                    jsonObjectDetails.getString("local_id"),
                                    jsonObjectDetails.getJSONObject("local_hospital"),
                                    jsonObjectDetails.getJSONObject("hospitals"),
                                )
                                adapter = HospitalAdapter(hospitalList)
                                binding.recyclerView.adapter = adapter
                                hospitalList.add(hospital)
                            }

                        } catch (e: JSONException) {
                            e.printStackTrace()
                        }
                    }, Response.ErrorListener { error ->
                        // displaying toast message on response failure.
                        Log.e("Error Response", "error is " + error!!.message)
                        Toast.makeText(this.context, "Fail to get data..", Toast.LENGTH_SHORT)
                            .show()
                    }){}

        queue.add(request)
        queue.cache
    }



}