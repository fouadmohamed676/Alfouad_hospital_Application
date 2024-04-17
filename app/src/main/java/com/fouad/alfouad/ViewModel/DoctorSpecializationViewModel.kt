package com.fouad.alfouad.ViewModel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fouad.alfouad.Doctor
import com.fouad.alfouad.Model.specialization_doctors.all_sp.Response
import com.fouad.alfouad.Network.Api.RetrofitInstance
import kotlinx.coroutines.launch

class DoctorSpecializationViewModel :ViewModel() {

    private val allSpsDoctors :MutableLiveData<List<Response>> =MutableLiveData()
    val spDoctors:LiveData<List<Response>>
        get() = allSpsDoctors
        //كل تخصصات الاطباء
    private val details_ = MutableLiveData<List<Doctor>>()
    val details:LiveData<List<Doctor>>
        get() = details_
   private val doctors_ = MutableLiveData<List<com.fouad.alfouad.Model.SpDoctors.Doctor>>()
    val myDoctors:LiveData<List<com.fouad.alfouad.Model.SpDoctors.Doctor>>
        get() = doctors_


    @SuppressLint("SuspiciousIndentation")
    fun getAllDoctorSps(){
        viewModelScope.launch {    //كل تخصصات الاطباء
            // get all Specializations doctors
            val doctorSpecialization=RetrofitInstance.api.getAllDoctorSpecializations()
            if (doctorSpecialization.isSuccessful){

                Log.e("TAG","allSp Vm : ${doctorSpecialization.body()!!.response}")
                allSpsDoctors.value=doctorSpecialization.body()!!.response
            }
        }
    }

    fun doctors(sp_id :Int){
        viewModelScope.launch {
                // get doctors in this Specialization with spic_id
            val getDoctors=RetrofitInstance.api.getResponseSp(sp_id)
            if (getDoctors.isSuccessful){
                Log.e("TAG","getDocIdSpVM  : ${getDoctors.body()!!.doctors}")
                doctors_.value = getDoctors.body()!!.doctors
            }
        }
    }


}