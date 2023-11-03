package com.fouad.alfouad.Network.Api

import com.fouad.alfouad.ClinkResponseModel
import com.fouad.alfouad.Model.ResponseResult
import retrofit2.Response
import retrofit2.http.GET

interface NetworkApi {
    @GET("hospital/show")
    suspend fun getHospitals(): Response<ResponseResult>
    @GET("clink/show")
    suspend fun getClinks():Response<ClinkResponseModel>
}