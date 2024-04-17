package com.fouad.alfouad.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fouad.alfouad.Model.pation.Pation
import com.fouad.alfouad.Network.Api.RetrofitInstance
import kotlinx.coroutines.launch
import java.lang.Exception

class RegisterViewModel  : ViewModel() {

    private val pation: MutableLiveData<Pation> = MutableLiveData()
    val registerPation: LiveData<Pation>
        get() = pation

    fun  register(){
        viewModelScope.launch {
            val fetchPation= RetrofitInstance.api.register()
            if (fetchPation.isSuccessful){
                try {
                    pation.value=fetchPation.body()!!.pation
                }catch (e: Exception){
                    Log.e("Register ViewModel Exception : ", "${e.message}")
                }
            }
        }
    }



}