package com.fouad.alfouad.ViewModel


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fouad.alfouad.DoctorHospital
import com.fouad.alfouad.Model.doctor.Response
import com.fouad.alfouad.Time
import com.fouad.alfouad.Network.Api.RetrofitInstance
import kotlinx.coroutines.launch
import java.lang.Exception

class DoctorViewModel :ViewModel() {

    private val doctors: MutableLiveData<Response> = MutableLiveData()
            val getDoctor: LiveData<Response>
        get() = doctors

    private val doctorsDays: MutableLiveData<List<Time>> = MutableLiveData()
            val getDoctorDays: LiveData<List<Time>>
        get() = doctorsDays

    private val doctorsHospitals: MutableLiveData<List<DoctorHospital>> = MutableLiveData()
            val getDoctorHospitals: LiveData<List<DoctorHospital>>
        get() = doctorsHospitals

     fun myDoctors(doctor_id: Int) {
        viewModelScope.launch {
            val fetchDoctors = RetrofitInstance.api.getDoctors(doctor_id)
            if (fetchDoctors.isSuccessful) {
                    try {
//                  Log.e("DoctorViewModel fetchDoctors : ", "${fetchDoctors.body()!!.response}")
                    doctors.value=fetchDoctors.body()!!.response
                    }catch (e: Exception){
                        Log.e("DoctorViewModel Exception : ", "${e.message}")
                    }

            }
        }

    }

     fun myDoctorsDays(doctor_id :Int) {
         viewModelScope.launch {
             val fetchDays = RetrofitInstance.api.getDoctors(doctor_id)
             if (fetchDays.isSuccessful) {
                 try {
                     doctorsDays.value=fetchDays.body()!!.response.times
                 }catch (e: Exception){
//                     Log.e("DaysViewModel Exception : ", "${e.message}")
                 }
                 }
         }
    }
     fun myDoctorsHospitals(hospital_id :Int) {
        viewModelScope.launch {
            val fetchHospitals = RetrofitInstance.api.getDoctors(hospital_id)
            if (fetchHospitals.isSuccessful) {
                try {

                  Log.e("Hospitals VM : ", "${fetchHospitals.body()!!.response}")
                  doctorsHospitals.value = fetchHospitals.body()!!.response.doctors
                }catch (e: Exception){
                    Log.e("HospitalsViewModel Exception : ", "${e.message}")
                }
            }
        }
    }
}


