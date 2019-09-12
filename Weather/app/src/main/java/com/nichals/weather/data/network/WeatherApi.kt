package com.nichals.weather.data.network

import com.nichals.weather.data.model.WeatherResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit


interface WeatherApi {
    @GET("data/2.5/weather?")
    fun getCurrentWeatherDataLatLong(@Query("lat") lat: String, @Query("lon") lon: String, @Query("APPID") app_id: String): Call<WeatherResponse>

    @GET("data/2.5/weather?")
    fun getCurrentWeatherData(@Query("q") city: String, @Query("units") unit: String, @Query("APPID") app_id: String): Call<WeatherResponse>


    companion object{
            operator fun invoke() : WeatherApi{
                return Retrofit.Builder()
                    .baseUrl("https://api.openweathermap.org")
                    .client(getOkHttpClient().build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(WeatherApi::class.java)
            }

            fun getOkHttpClient(): OkHttpClient.Builder {
                val logging = HttpLoggingInterceptor()
                logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                val okHttpClientBuilder = OkHttpClient.Builder()
                okHttpClientBuilder.connectTimeout(30, TimeUnit.SECONDS)
                okHttpClientBuilder.readTimeout(30, TimeUnit.SECONDS)
                okHttpClientBuilder.addInterceptor(logging)
                return okHttpClientBuilder
            }

    }



}

