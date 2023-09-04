package com.example.myapplicationsample.utils

sealed class Resource<out T> {
    data class Success<out T>(val value: T) : Resource<T>()
    data class Failure (val throwable:Throwable) : Resource<Nothing>()
    data object Loading : Resource<Nothing>()
}
