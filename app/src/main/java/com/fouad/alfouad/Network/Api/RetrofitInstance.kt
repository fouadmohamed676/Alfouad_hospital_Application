package com.fouad.alfouad.Network.Api

import com.fouad.alfouad.Network.Data
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
private const val baseUrl=Data.Base_Url_Api  //"https://192.168.137.1:8000/api/"
object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api :NetworkApi by lazy {
        retrofit.create(NetworkApi::class.java)
    }
}