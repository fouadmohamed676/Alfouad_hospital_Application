package com.fouad.alfouad.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fouad.alfouad.Network.Api.RetrofitInstance
import com.fouad.alfouad.Response
import kotlinx.coroutines.launch

class HospitalDetailsViewModel :ViewModel() {
private val details_ = MutableLiveData<Response>()
    val details:LiveData<Response>
        get() = details_

    fun  hospitalDetails(hospitalId : Int){
        val api =RetrofitInstance.api
        viewModelScope.launch {
            val fetchHospital=api.getHospital(hospitalId)
            details_.value=fetchHospital
        }
    }
}