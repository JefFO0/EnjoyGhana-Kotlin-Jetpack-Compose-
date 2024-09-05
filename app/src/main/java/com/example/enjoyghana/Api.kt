package com.example.enjoyghana

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val baseUrl = "https://api.weatherapi.com/v1/"
val retrofit: Retrofit = Retrofit.Builder().baseUrl(baseUrl)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val weatherApiAndRetrofit: WeatherApi = retrofit.create(WeatherApi::class.java)

interface WeatherApi {
    @GET("current.json?key=4eecfbc6430548cb87d105958243007&q=Accra&aqi=no")
    suspend fun getWeather(
//        @Query("q") city: String,
    ): Response<TheWeather>

}
//
//private const val baseUrlOfTourismApi = "https://tourism-backend-five.vercel.app/api/v1"
//val retrofitOfTourismApi: Retrofit = Retrofit.Builder().baseUrl(baseUrlOfTourismApi)
//    .addConverterFactory(GsonConverterFactory.create())
//    .build()
//
//val tourismApiAndRetrofit: TourismApi = retrofitOfTourismApi.create(TourismApi::class.java)
//
//interface TourismApi{
//    @GET("/locations")
//    suspend fun getAttractions():TourismLocations
//}