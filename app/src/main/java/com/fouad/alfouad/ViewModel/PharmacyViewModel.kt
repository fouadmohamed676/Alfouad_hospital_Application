package com.fouad.alfouad.ViewModel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fouad.alfouad.Model.pharmacy.id.Day
import com.fouad.alfouad.Model.pharmacy.id.Staff
//import com.fouad.alfouad.Staff
import com.fouad.alfouad.Network.Api.RetrofitInstance
import com.fouad.alfouad.ResponsePharmacy
import kotlinx.coroutines.launch

class PharmacyViewModel :ViewModel() {
    private  val data: MutableLiveData<List<ResponsePharmacy>> = MutableLiveData()
    val allPharmacy:LiveData<List<ResponsePharmacy>>
        get() = data

    private  val days: MutableLiveData<List<Day>> = MutableLiveData()
    val daysPharmacy:LiveData<List<Day>>
        get() = days


    private  val staffs: MutableLiveData<List<Staff>> = MutableLiveData()
    val staffsPharmacy:LiveData<List<Staff>>
        get() = staffs

    fun getData(){
        viewModelScope.launch {
           val fetchData=RetrofitInstance.api.getPharmacy()
//            Log.e("response : ","${fetchData.body()}")
            if (fetchData.isSuccessful){
                Log.e("response 2 : ","${fetchData.body()!!.response}")
                try {
                    data.value= fetchData.body()!!.response
                }catch (e: Exception){
                    Log.e(TAG,"Pharmacy Exception :  ${e.message}")
                }
            }
        }
    }
    fun getDays(pharmacy_id :Int){
        viewModelScope.launch {
            val fetchDays=RetrofitInstance.api.getPharmacyData(pharmacy_id)
//            Log.e("fetchDaysPharmacyData : ","${fetchDays.body()!!.response}")
            if (fetchDays.isSuccessful){
                Log.e("fetch Days : ","${fetchDays.body()!!}")
//                try {
////                    days.value= fetchDays.body()!!.response
//                }catch (e: Exception){
//                    Log.e(TAG,"Pharmacy days :  ${e.message}")
//                }
            }
        }
    }
    fun getStaffs(pharmacy_id :Int){
        viewModelScope.launch {
            val fetchStaffs=RetrofitInstance.api.getPharmacyStaff(pharmacy_id)
            Log.e("fetchStaffsPharmacyStaff : ","${fetchStaffs.body()!!.response}")
            if (fetchStaffs.isSuccessful){

//                try {
////                    staffs.value= fetchStaffs.body()!!.response.staffs
//                }catch (e: Exception){
//                    Log.e(TAG,"Pharmacy getPharmacyStaff :  ${e.message}")
//                }
            }
        }
    }

}