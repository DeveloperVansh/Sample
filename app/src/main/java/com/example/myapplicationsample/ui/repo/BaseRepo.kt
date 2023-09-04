package com.example.myapplicationsample.ui.repo

import com.example.myapplicationsample.network.ApiSerivce
import com.example.myapplicationsample.network.RetrofitClient
import com.example.myapplicationsample.utils.Constants
import com.example.myapplicationsample.utils.SafeApiCall

abstract class BaseRepo: SafeApiCall {
    private val manager: RetrofitClient = RetrofitClient()
    var apiService: ApiSerivce = manager.createService(Constants.BASEURL)
}