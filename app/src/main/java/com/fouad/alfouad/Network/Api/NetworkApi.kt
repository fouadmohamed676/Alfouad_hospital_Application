package com.fouad.alfouad.Network.Api

import com.fouad.alfouad.Model.User
import com.fouad.alfouad.Model.hospital.Doctor
import com.fouad.alfouad.Model.hospital.HospitalBojo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface NetworkApi {
    @GET("hospital")
    suspend fun getHospitals(): Response<HospitalBojo>
    @GET("hospital/{id}")
    suspend fun getHospital(@Path("id") hospitalId:Int ) :Response<Doctor>
    @GET("clink/show")
    suspend fun getClinks():Response<com.fouad.alfouad.Response>
    @POST("user/api")

    suspend fun login():Response<User>
//    @POST("interview/{id}")
//    suspend fun interviews(interView_id: Int):Response<InterView>

}