package com.fouad.alfouad.ViewModel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fouad.alfouad.Response
import com.fouad.alfouad.Network.Api.RetrofitInstance
import kotlinx.coroutines.launch
import java.lang.Exception

class HospitalViewModel :ViewModel() {
    private  val hospital_ :MutableLiveData<List<Response>> = MutableLiveData()
    val hospitals :LiveData<List<Response>>
        get() = hospital_
    fun getHospitals(){
        viewModelScope.launch {

            val fetchedHospitals = RetrofitInstance.api.getHospitals()

            if (fetchedHospitals.isSuccessful){


                try {
                    hospital_.value=fetchedHospitals.body()!!.response

                }catch (e: Exception){
                    Log.e(TAG,"Hospitals Exception :  ${e.message}")

                }

            }
        }
    }

}