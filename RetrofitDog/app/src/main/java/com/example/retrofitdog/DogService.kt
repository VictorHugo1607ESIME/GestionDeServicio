package com.example.retrofitdog

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface DogService {
    @GET("{breed}/images/random/10/")
    suspend fun getDogList(@Path("breed") breed: String): Response<DogModel>
}
private var retrofit = Retrofit.Builder()
    .baseUrl("https://dog.ceo/api/breed/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

var service: DogService = retrofit.create<DogService>(DogService::class.java)