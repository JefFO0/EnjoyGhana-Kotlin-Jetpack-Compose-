package com.example.enjoyghana

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class MVModel (
num : Int
): ViewModel() {

    private val _selectedTabIndex =
        mutableIntStateOf(num)
    var selectedTabIndex: MutableState<Int> = _selectedTabIndex

    private val weatherApi = weatherApiAndRetrofit
    private val _weatherApiResponse = MutableLiveData<NetworkResponse<TheWeather>>()
    val weatherApiResponse: MutableLiveData<NetworkResponse<TheWeather>> = _weatherApiResponse

    fun getData(city: String){
        viewModelScope.launch {
         try {
             val response =   weatherApi.getWeather(
//                    city = city
                )
             if (response.isSuccessful) {
              response.body()?.let {
                  _weatherApiResponse.value = NetworkResponse.Success(it)
              }
             }
             else {
              _weatherApiResponse.value = NetworkResponse.Error("Failed to load weather")
             }
         } catch (e: Exception) {
             _weatherApiResponse.value = NetworkResponse.Error("Failed to load weather")
         }
        }
    }

//    fun getTourismApi(){
//        viewModelScope.launch {
//            try {
//                val response = tourismApiAndRetrofit.getAttractions()
//            }
//            catch (e: Exception){
//                Log.d("TAG", "getTourismApi: ${e.message}")
//            }
//        }
//    }


}