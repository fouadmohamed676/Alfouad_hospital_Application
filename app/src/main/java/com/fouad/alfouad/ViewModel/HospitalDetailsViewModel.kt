package com.fouad.alfouad.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fouad.alfouad.Model.hospital.Doctor
import com.fouad.alfouad.Network.Api.RetrofitInstance
import kotlinx.coroutines.launch

class HospitalDetailsViewModel :ViewModel() {
private val details_ = MutableLiveData<Doctor>()
    val details:LiveData<Doctor>
        get() = details_
    fun  hospitalDetails(hospitalId : Int){
        val api =RetrofitInstance.api
        viewModelScope.launch {
            val fetchHospital=api.getHospital(hospitalId)

            if (fetchHospital.isSuccessful){
                details_.value=fetchHospital.body()!!
            }
        }
    }
}