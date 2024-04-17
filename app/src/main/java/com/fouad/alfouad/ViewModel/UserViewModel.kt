package com.fouad.alfouad.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fouad.alfouad.Model.auth.Response
import com.fouad.alfouad.Network.Api.RetrofitInstance
import kotlinx.coroutines.launch

class UserViewModel :ViewModel(){
    private val user :MutableLiveData<List<Response>> = MutableLiveData()
    val userData:LiveData<List<Response>> get() =
        user
    fun getUser(phone :String)=

         viewModelScope.launch {
             val data=RetrofitInstance.api.auth_(phone)

             Log.e("Login Success", "${data.response}")
             if (data.status=="success") {

                 try {
                     Log.e("Login Success", "${data.response}")
                     user.value=data.response

                 } catch (e: Exception) {
                     Log.e("Login Failed User Exception ", "${e.message}")
                 }
             }

        }

}