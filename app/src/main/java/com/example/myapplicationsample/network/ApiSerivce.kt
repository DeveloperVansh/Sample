package com.example.myapplicationsample.network

import com.example.myapplicationsample.network.model.response.Response
import com.example.myapplicationsample.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiSerivce {
    @GET(Constants.BASEURL)
    suspend fun  apicall(@Query ("count") count:Int):Response


}