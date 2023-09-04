package com.example.myapplicationsample.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplicationsample.network.model.response.Response
import com.example.myapplicationsample.ui.repo.MainRepostiry
import com.example.myapplicationsample.utils.Resource
import kotlinx.coroutines.launch

class MainViewModel(private val mainRepostiry: MainRepostiry) : BaseViewModel(mainRepostiry) {
    private val mMutableLiveData: MutableLiveData<Resource<Response>> = MutableLiveData()
    val isRealtime: LiveData<Resource<Response>>
        get() = mMutableLiveData


    fun apiCall(count: Int) = viewModelScope.launch {
        mMutableLiveData.value = Resource.Loading
        mMutableLiveData.value = mainRepostiry.main(3)

    }
}