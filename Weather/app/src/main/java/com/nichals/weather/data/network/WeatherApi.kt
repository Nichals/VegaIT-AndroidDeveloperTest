package com.nichals.weather.data.network

import com.nichals.weather.data.WeatherResponse
import retrofit2.Call
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherApi {
        @GET("data/2.5/weather?")
        fun getCurrentWeatherDataLatLong(@Query("lat") lat: String, @Query("lon") lon: String, @Query("APPID") app_id: String): Call<WeatherResponse>

    @GET("data/2.5/weather?")
    fun getCurrentWeatherData(@Query("") city: String, @Query("") loc: String, @Query("APPID") app_id: String): Call<WeatherResponse>


    companion object{
            operator fun invoke() : WeatherApi{
                return Retrofit.Builder()
                    .baseUrl("https://api.openweathermap.org")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(WeatherApi::class.java)
            }
        }



}

