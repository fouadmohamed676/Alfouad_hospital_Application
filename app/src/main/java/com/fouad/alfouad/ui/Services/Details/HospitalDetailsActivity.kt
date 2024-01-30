package com.fouad.alfouad.ui.Services.Details

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.fouad.alfouad.Adapter.HospitalAdapter
import com.fouad.alfouad.Adapter.HospitalDetailsAdapter
import com.fouad.alfouad.Fragment.EXTRA
import com.fouad.alfouad.Model.hospital.HospitalBojo
import com.fouad.alfouad.Network.Data
import com.fouad.alfouad.R
import com.fouad.alfouad.ViewModel.HospitalDetailsViewModel
import com.fouad.alfouad.ViewModel.HospitalViewModel
import com.fouad.alfouad.databinding.ActicivtyDetailsHospitalBinding
import org.json.JSONException
import org.json.JSONObject
import java.util.Objects

@Suppress("DEPRECATION")
class HospitalDetailsActivity :AppCompatActivity(R.layout.acticivty_details_hospital){
    private lateinit var binding: ActicivtyDetailsHospitalBinding

    private  val hospitalList: ArrayList<HospitalBojo> = ArrayList()
    private lateinit var adapter: HospitalDetailsAdapter
    private lateinit var manager : RecyclerView.LayoutManager
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var viewModel: HospitalDetailsViewModel

//    private lateinit var id:String
//    private var people:Int=1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActicivtyDetailsHospitalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(HospitalDetailsViewModel::class.java)
       val people = intent.getSerializableExtra(EXTRA) as? com.fouad.alfouad.Response
        setupLayout()
        Log.e("hospital people : ","$people")

//        id = intent.getStringExtra("id") as String
//        response()
    }
    private  fun setupLayout(){
        manager= LinearLayoutManager(this)
        layoutManager= LinearLayoutManager(this)
        binding.hospitalDetails.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.hospitalDetails.layoutManager = layoutManager
        binding.hospitalDetails.setHasFixedSize(true)
    }


    fun responsse (){

        viewModel.details.observe(this, Observer {

                hospitals->

            Log.e("hospital Details : ","$hospitals")

//            blogHospital.addAll(hospitals)
//            adapter = HospitalAdapter(hospitals)
//            adapter.notifyDataSetChanged()
//            binding.recyclerView.adapter = adapter
        })
        viewModel.hospitalDetails(1)
    }






//    private fun getData() {
//        val queue = Volley.newRequestQueue(this)
//        val request: StringRequest =
//            @SuppressLint("SuspiciousIndentation")
//            object : StringRequest(
//                Request.Method.GET, Data.show_hospital+id,
//                Response.Listener<String> { response ->
//                    try {
//                        val obj = JSONObject(response)
//                        val jsonArrayInfo = obj.getJSONArray("response")
//                        Log.e("response","$jsonArrayInfo")
//                        val size: Int = jsonArrayInfo.length()
//                        for (i in 0 until size) {
//                            val jsonObjectDetails: JSONObject = jsonArrayInfo.getJSONObject(i)
//                            Log.e("response  :  ","$jsonObjectDetails")
////                            val hospitalDetails = HospitalBojo(
////                                jsonObjectDetails.getJSONObject("doctors"),
////                                jsonObjectDetails.getString("id"),
////                            )
//
////                            adapter = HospitalDetailsAdapter(hospitalList)
////                            binding.hospitalDetails.adapter = adapter
////                            hospitalList.add(hospitalDetails)
//                        }
//
//
//                    } catch (e: JSONException) {
//                        e.printStackTrace()
//                    }
//                },
//                Response.ErrorListener { volleyError ->
//                    Toast.makeText(this,"الرجاء الاتصال بالشبكه",Toast.LENGTH_SHORT).show()
//                    Log.e("Error", " No Internet Connection.. $volleyError") }) {
//
//            }
//        queue.add(request)
//    }

}