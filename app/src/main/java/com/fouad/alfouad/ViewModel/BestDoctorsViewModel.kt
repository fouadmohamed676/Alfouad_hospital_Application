package com.fouad.alfouad.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fouad.alfouad.Model.best_doctors.Response
import com.fouad.alfouad.Network.Api.RetrofitInstance
import kotlinx.coroutines.launch

class BestDoctorsViewModel :ViewModel() {

    private  val  doctorsResponse : MutableLiveData <List<Response>> = MutableLiveData()
    val responseDoctors : LiveData<List<Response>> get() =
        doctorsResponse

    fun getDoctorsData(){
        viewModelScope.launch {
            val fetchDoctors =RetrofitInstance.api.bestDoctors()

            if (fetchDoctors.isSuccessful){
                doctorsResponse.value=fetchDoctors.body()!!.response
            }
        }
    }


}