package com.fouad.alfouad.Network

import com.android.volley.Response
import com.fouad.alfouad.Model.ResponseListUsers
import retrofit2.http.GET

interface ApiInterface {
//    @GET("/pations/")
//     fun getuser() : Response<User>
    @GET("hospital.php")
//    suspend fun getAllUsers(): Response<Locals>
    suspend fun getAllUsers(): Response<ResponseListUsers>
}