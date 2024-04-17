package com.fouad.alfouad.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fouad.alfouad.Model.specializations_hospital.Hospital
import com.fouad.alfouad.Model.specializations_hospital.all_sp_hospitals.ResponseAllSpHospitals
import com.fouad.alfouad.Network.Api.RetrofitInstance
import kotlinx.coroutines.launch

class HospitalSpecializationViewModel :ViewModel() {
    private  val hospital =MutableLiveData<List<ResponseAllSpHospitals>>()
    val hospitalList :LiveData<List<ResponseAllSpHospitals>> get() =
        hospital //get one hospital with Specialization


    private  val hospitals =MutableLiveData<List<Hospital>>()
    val hospitalsList :LiveData<List<Hospital>> get() =
        hospitals

    fun myHospitals(hospital_id :Int){   //get doctors in this sp with spic_id
        viewModelScope.launch {
            val hospitalData = RetrofitInstance.api.getHospitalSpecialization(hospital_id)
            if (hospitalData.isSuccessful){
                hospitals.value=hospitalData.body()!!.hospitals
            }

        }
    }
    fun myAllHospitalsSp(){ // get all sp in hospitals
        viewModelScope.launch {
            val hospitalsData = RetrofitInstance.api.getAllHospitalSpecialization()
            if (hospitalsData.isSuccessful){
                hospital.value=hospitalsData.body()!!.response
            }

        }
    }

}