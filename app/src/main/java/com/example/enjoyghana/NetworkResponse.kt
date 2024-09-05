package com.example.enjoyghana

// T REFERS TO THE DATA CLASS OF THE RESPONSE WHICH IN THIS CASE IS THE weatherApiAndRetrofit
sealed class NetworkResponse<out T> {
    data class Success<out T>(val data: T) : NetworkResponse<T>()
    data class Error(val message: String) : NetworkResponse<Nothing>()
    data object Loading : NetworkResponse<Nothing>()
}