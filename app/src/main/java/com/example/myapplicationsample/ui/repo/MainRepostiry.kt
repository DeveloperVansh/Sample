package com.example.myapplicationsample.ui.repo


class MainRepostiry : BaseRepo() {

    suspend fun main(count: Int) = safeApiCall {
      apiService.apicall(count)
    }

}