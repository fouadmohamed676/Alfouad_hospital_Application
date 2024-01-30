package com.fouad.alfouad.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fouad.alfouad.Response
import com.fouad.alfouad.Network.Api.RetrofitInstance
import kotlinx.coroutines.launch

class HospitalViewModel :ViewModel() {
    private  val hospital_ :MutableLiveData<List<Response>> = MutableLiveData()
    val hospitals :LiveData<List<Response>>
        get() = hospital_
    fun getHospitals(){
        viewModelScope.launch {

            val fetchedHospitals = RetrofitInstance.api.getHospitals()

            if (fetchedHospitals.isSuccessful){
                hospital_.value=fetchedHospitals.body()!!.response
            }
        }
    }

}