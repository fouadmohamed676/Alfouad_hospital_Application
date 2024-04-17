package com.fouad.alfouad.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fouad.alfouad.Doctor
import com.fouad.alfouad.Network.Api.RetrofitInstance
import kotlinx.coroutines.launch
import java.lang.Exception

class HospitalDetailsViewModel :ViewModel() {
private val details_ = MutableLiveData<List<Doctor>>()
    val details:LiveData<List<Doctor>>
        get() = details_
    fun  hospitalDetails(hospitalId : Int){
        val api =RetrofitInstance.api
        viewModelScope.launch {
            val fetchHospital=api.getHospital(hospitalId)
            if (fetchHospital.isSuccessful) {
                Log.e("Hospital view model : ",fetchHospital.body()!!.response.toString())
                try {
                    details_.value = fetchHospital.body()!!.response.doctor

                } catch (e: Exception) {

                    Log.e("response Exception", "null ${e.message}")
                }
            }
        }
    }
}