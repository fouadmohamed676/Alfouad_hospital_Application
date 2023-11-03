package com.fouad.alfouad.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fouad.alfouad.Network.Api.RetrofitInstance
import com.fouad.alfouad.ClinkResponse
import kotlinx.coroutines.launch

class ClinkViewModel :ViewModel() {
private val clink_: MutableLiveData<List<ClinkResponse>> = MutableLiveData()
    val clinks :LiveData<List<ClinkResponse>>
        get() = clink_

    fun  getClink(){
        viewModelScope.launch {
            val fetchClink=RetrofitInstance.api.getClinks()
             if (fetchClink.isSuccessful){

//                 Log.e("response  fetchClink",fetchClink.body()?.cLinkResponse.toString())

                 clink_.value=fetchClink.body()?.cLinkResponse
            }
            else{
                 Log.e("response  error","Error")

             }
        }
    }
}