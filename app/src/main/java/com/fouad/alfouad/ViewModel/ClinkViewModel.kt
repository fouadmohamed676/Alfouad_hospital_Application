package com.fouad.alfouad.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fouad.alfouad.Network.Api.RetrofitInstance
import com.fouad.alfouad.ResponseClink
import kotlinx.coroutines.launch
import java.lang.Exception

class ClinkViewModel :ViewModel() {

    private val clink_: MutableLiveData<List<ResponseClink>> = MutableLiveData()
    val clinks :LiveData<List<ResponseClink>>
        get() = clink_

    fun  getClink(){
        viewModelScope.launch {
            val fetchClink=RetrofitInstance.api.getClinks()

             if (fetchClink.isSuccessful){
                 try {
                     clink_.value=fetchClink.body()!!.response
                 }catch (e: Exception){
                     Log.e("response Exception",e.message.toString())
                 }
            }
            else{
                 Log.e("response  error","Error")
             }
        }
    }

}