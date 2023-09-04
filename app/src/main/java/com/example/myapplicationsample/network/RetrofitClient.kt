package com.example.myapplicationsample.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    fun createService(baseUrl: String): ApiSerivce {
        val retrofit = getRetrofit(baseUrl)
        return retrofit.create(ApiSerivce::class.java)
    }

    private fun getRetrofit(baseUrl: String): Retrofit {
        val client = OkHttpClient.Builder().build()
        return Retrofit.Builder().baseUrl(baseUrl).client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}