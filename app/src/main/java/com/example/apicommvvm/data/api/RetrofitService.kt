package com.example.apicommvvm.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    companion object{
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(JsonPlaceHolderApi::class.java)
    }
}