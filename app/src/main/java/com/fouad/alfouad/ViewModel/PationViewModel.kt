package com.fouad.alfouad.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fouad.alfouad.Model.create_pation.Blood
import com.fouad.alfouad.Model.create_pation.Local
import com.fouad.alfouad.Model.create_pation.Nationality
import com.fouad.alfouad.Network.Api.RetrofitInstance
import kotlinx.coroutines.launch
import java.lang.Exception

class PationViewModel:ViewModel() {
    private val bloods : MutableLiveData<List<Blood>> = MutableLiveData()
    val userBlood: LiveData<List<Blood>>
        get() =
            bloods

    private val locals : MutableLiveData<List<Local>> = MutableLiveData()
    val userLocals: LiveData<List<Local>>
        get() =
        locals

    private val nationality : MutableLiveData<List<Nationality>> = MutableLiveData()
    val userNationality: LiveData<List<Nationality>>
        get() =
            nationality


    fun getBloods(){
        viewModelScope.launch {
            val data= RetrofitInstance.api.allpations()
            if (data.isSuccessful) {
                try {
                    bloods.value=data.body()!!.blood
                    Log.e("Login Success", "${data.body()}")
                } catch (e: Exception) {
                    Log.e("Login Failed User Exception ", "${e.message}")
                }
            }

        }

    }
    fun getLocals(){
        viewModelScope.launch {
            val data= RetrofitInstance.api.allpations()
            if (data.isSuccessful) {
                try {
                    locals.value=data.body()!!.locals
                    Log.e("Login Success", "${data.body()!!.nationality}")
                } catch (e: Exception) {
                    Log.e("Login Failed User Exception ", "${e.message}")
                }
            }

        }

    }
    fun getNationalities(){
        viewModelScope.launch {
            val data= RetrofitInstance.api.allpations()
            if (data.isSuccessful) {
                try {
                    nationality.value=data.body()!!.nationality
                    Log.e("Login Success", "${data.body()!!.nationality}")
                } catch (e: Exception) {
                    Log.e("Login Failed User Exception ", "${e.message}")
                }
            }

        }

    }

}