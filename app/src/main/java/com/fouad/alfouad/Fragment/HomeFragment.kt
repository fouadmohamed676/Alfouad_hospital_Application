@file:Suppress("DEPRECATION")

package com.fouad.alfouad.Fragment

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.fouad.alfouad.Adapter.HospitalAdapter
import com.fouad.alfouad.Model.Hos
import com.fouad.alfouad.Network.Data
import com.fouad.alfouad.R
import com.fouad.alfouad.databinding.HomeFragmentBinding
import com.fouad.alfouad.ui.Services.ClinkActivity
import com.fouad.alfouad.ui.Services.HospitalActivity
import com.fouad.alfouad.ui.Services.PharmacyActivity
import org.json.JSONException
import org.json.JSONObject

@Suppress("DEPRECATION")
class HomeFragment:Fragment(R.layout.home_fragment) {

   private lateinit var binding: HomeFragmentBinding
   private lateinit var adapter: HospitalAdapter
   private lateinit var hospital_list:ArrayList<Hos>
   private lateinit var hospitalAdapter: HospitalAdapter
   private lateinit var layoutManager: LinearLayoutManager
   private lateinit var linearLayoutManager: RecyclerView.LayoutManager
   lateinit var progressDialog:ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=HomeFragmentBinding.inflate(layoutInflater)
        progressDialog = ProgressDialog(activity)
        getHospital()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val  view:View=inflater.inflate(R.layout.home_fragment,container,false)
        binding=HomeFragmentBinding.bind(view)
        setupLayout()

        binding.clink.setOnClickListener {

            val intentClink=Intent(view.context,ClinkActivity::class.java)
            startActivity(intentClink)

        }
        binding.hospitalBtn.setOnClickListener{
            val intent=Intent(view.context,HospitalActivity::class.java)
            startActivity(intent)
        }
        binding.pharmBtn.setOnClickListener{
            val intent=Intent(view.context,PharmacyActivity::class.java)
            startActivity(intent)
        }
        return view
    }

    private  fun setupLayout(){
        layoutManager = LinearLayoutManager(activity)
//        binding.recycle.layoutManager=layoutManager
//        binding.recycle.setHasFixedSize(true)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        binding.recycle.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
    }


    private  fun getHospital(){


//            Hos("3","مستشفى الروضه","أمدرمان","عظام"),
//            Hos("4","الوالدين","الخرطوم","طوارئ وإصابات"),
//            Hos("5","دار العلاج","الخرطوم","أطفال"),
//            Hos("6","مستشفى احمد قاسم","بحري","نساء وتوليد"),
//            Hos("7","مستشفى النو","أمدرمان","عظام"),
//            Hos("8","الفؤاد التخصصي","الخرطوم","طوارئ وإصابات"),
//            Hos("9","مستشفى الخرطوم التعليمي","بحري","أسنان"),
//            Hos("10","مستشفى الروضه","أمدرمان","عظام"),
//        )
//        set_hospital(hospital)

    }

    private fun getAdds() {
//        addsArrayList.clear()
//        starProgress()
        val queue = Volley.newRequestQueue(activity)
        val request: StringRequest =
            @SuppressLint("SuspiciousIndentation")
            object : StringRequest(
                Method.GET, Data.user,
                Response.Listener<String?> { response ->
                    try {
//                        stopProgress()
                        val jsonContact = JSONObject(response)
                        val jsonArrayInfo = jsonContact.getJSONArray("data")


//                        val size: Int = jsonArrayInfo.length()


//                        for (i in 0 until size) {
//                            val jsonObjectDetails: JSONObject = jsonArrayInfo.getJSONObject(i)
//
//                            val adds = Adds(
//                                jsonObjectDetails.getString("title"),
//                                jsonObjectDetails.getString("image"),
//                                jsonObjectDetails.getString("content"),
//                                jsonObjectDetails.getString("price"),
//                                jsonObjectDetails.getString("type"),
//                                jsonObjectDetails.getString("date"),
//                                jsonObjectDetails.getString("min_aucation"),
//                                jsonObjectDetails.getString("start_date"),
//                                jsonObjectDetails.getString("end_date"),
//                                jsonObjectDetails.getString("city"),
//                                jsonObjectDetails.getString("category_id"),
//                                jsonObjectDetails.getString("id"),
//                                jsonObjectDetails.getJSONObject("user"),
//                                jsonObjectDetails.getString("section_id"),
//                                jsonObjectDetails.getString("category"),
//                            )
//
////                            setAdds(adds)
//                        }

                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }, Response.ErrorListener {
                    // Error message on response failure.
                    Log.e("Connection", "No Internet Connection..")
                }) {
            }
        queue.add(request)
        queue.cache
    }

    private fun set_hospital(hos: ArrayList<Hos>){
//        adapter = HospitalAdapter(hospital_list)
//        binding.recycle.adapter=adapter
        hospital_list
    }
    private fun getSections() {
//        sectionList.clear()
        val queue = Volley.newRequestQueue(activity)
        val request: StringRequest =
            @SuppressLint("SuspiciousIndentation")
            object : StringRequest(
                Method.GET, Data.user,
                Response.Listener<String?> { response2 ->
                    try {
                        val jsonContact = JSONObject(response2)
                        val jsonArrayInfo = jsonContact.getJSONArray("data")
//                        val size: Int = jsonArrayInfo.length()

//                        val sectionModelAll = SectionModel(
//                            "0",
//                            "الكل",
//                            JSONArray(),
//                        )

//                        setSection(sectionModelAll)

//                        for (i in 0 until size) {
//                            val jsonObjectDetails: JSONObject = jsonArrayInfo.getJSONObject(i)
//                            val sectionModel = SectionModel(
//                                jsonObjectDetails.getString("id"),
//                                jsonObjectDetails.getString("name"),
//                                jsonObjectDetails.getJSONArray("categories")
//                            )

//                            setSection(sectionModel)


//                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }, Response.ErrorListener {   // Error message on response failure.
                    Log.e("Connection", "No Internet Connection..")
                }) {
            }
        queue.cache
        queue.add(request)
    }


}