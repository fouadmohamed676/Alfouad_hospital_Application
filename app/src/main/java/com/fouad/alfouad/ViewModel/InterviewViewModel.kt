package com.fouad.alfouad.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fouad.alfouad.Network.Api.RetrofitInstance
import kotlinx.coroutines.launch

class InterviewViewModel :ViewModel() {
//    private  val interview : MutableLiveData<List<ResponseInterView>> = MutableLiveData()
//    val interviews : LiveData<List<ResponseInterView>>
//        get() = interview
//    fun get_interviews(interView_id: Int){
//        viewModelScope.launch {
//
//            val fetchInterViews= RetrofitInstance.api.interviews(1)
//
//            if (fetchInterViews.isSuccessful){
//                interview.value=fetchInterViews.body()?.Mresponse
//            }
//        }
//    }


}