package com.fouad.alfouad.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fouad.alfouad.Forward
import com.fouad.alfouad.Model.pation.Pation
import com.fouad.alfouad.Model.pation.Sick
import com.fouad.alfouad.Network.Api.RetrofitInstance
import kotlinx.coroutines.launch
import java.lang.Exception

class ForwardsViewModel :ViewModel(){
private val data:MutableLiveData<List<Forward>> = MutableLiveData()
    val getForward:LiveData<List<Forward>>
    get() = data
    private val sick : MutableLiveData<List<Sick>> = MutableLiveData()
    val getSicks:LiveData<List<Sick>>
    get() = sick

    private val pation:MutableLiveData<Pation> = MutableLiveData()
    val getPation:LiveData<Pation>
    get() = pation


    fun  getPation(user_id: Int){
        viewModelScope.launch {
            val fetchPation=RetrofitInstance.api.pation(user_id)
            if (fetchPation.isSuccessful){
                try {
                    pation.value=fetchPation.body()!!.pation
                }catch (e: Exception){
                    Log.e("PationsViewModel Exception : ", "${e.message}")
                }
            }
        }
    }

    fun  allForwards(user_id: Int){
        viewModelScope.launch {
            val fetchForwards=RetrofitInstance.api.forwards(user_id)
            if (fetchForwards.isSuccessful){
                try {
                    data.value=fetchForwards.body()!!.forward
                }catch (e:Exception){
                    Log.e("ForwardsViewModel Exception : ", "${e.message}")
                }
            }
        }
    }

    fun  sicks(user_id: Int){
        viewModelScope.launch {
            val fetchBlood=RetrofitInstance.api.pation(user_id)
            if (fetchBlood.isSuccessful){
                try {
                    sick.value=fetchBlood.body()!!.pation.sicks
                }catch (e:Exception){
                    Log.e("SicksViewModel Exception : ", "${e.message}")

                }
            }
        }
    }
}