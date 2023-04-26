package com.example.retrofitdog.apiary

import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface apiary {
    @Headers("Content-Type:application/json")
    @POST("questions")
    suspend fun getDataApiaryPost(@Body request: apiaryRequestDTO) : Response<List<apiaryResponceDTO>>

    @GET("questions")
    suspend fun getDataApiaryGet(): Response<List<apiaryResponceGetDTO>>
}

private var retrofit = Retrofit.Builder()
    .baseUrl("https://private-392994-devtest16.apiary-proxy.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

var serviceApiary: apiary = retrofit.create(apiary::class.java)