package com.fouad.alfouad.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fouad.alfouad.Model.best_hospitals.Response
import com.fouad.alfouad.Network.Api.RetrofitInstance
import kotlinx.coroutines.launch

class BestHospitalsViewModel : ViewModel() {
    private  val hospitals  : MutableLiveData<List<Response>> = MutableLiveData()
    val myResponseHospitals : LiveData<List<Response>>
    get() = hospitals

    fun getBestHospitals(){
        viewModelScope.launch {
            val fetchHospitals =RetrofitInstance.api.bestHospitals()
            if (fetchHospitals.isSuccessful){
                hospitals.value=fetchHospitals.body()!!.response
            }
        }
    }
}