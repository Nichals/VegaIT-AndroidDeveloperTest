package com.nichals.weather.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nichals.weather.data.model.WeatherResponse
import com.nichals.weather.data.network.WeatherApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherRepository {

    var weatherResponse = MutableLiveData<ArrayList<WeatherResponse>>()
    var weatherApi = WeatherApi()
    val APP_ID = "dc0f9a0be7aea7f236131463dab3a19f"

    fun weatherCheck(): LiveData<ArrayList<WeatherResponse>> {

        weatherApi.getCurrentWeatherDataLatLong("-25.441105","-49.276855",APP_ID).enqueue(object :
            Callback<WeatherResponse> {

            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if(response.isSuccessful){
                    var weather = response.body() as WeatherResponse
                    weatherResponse.add(weather)
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.e("retorno",t.message )
            }
        })

        return weatherResponse
    }



    fun weatherCheckCity(city: String,weatherCityResponse:  MutableLiveData<ArrayList<WeatherResponse>>): MutableLiveData<ArrayList<WeatherResponse>>{

        weatherApi.getCurrentWeatherData(city,"metric",APP_ID).enqueue(object  : Callback<WeatherResponse>{
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if(response.isSuccessful){
                    var weather = response.body() as WeatherResponse
                    weatherCityResponse.add(weather)
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.e("retorno",t.message )
            }



        })
        return weatherCityResponse
    }


    fun <T> MutableLiveData<ArrayList<T>>.add(valueToAdd: T) {
        val value = this.value ?: arrayListOf()
        value.add(valueToAdd)
        this.value = value
    }

    fun weatherCheckCitys(cities: List<String>): MutableLiveData<ArrayList<WeatherResponse>> {
        var weatherCityResponse = MutableLiveData<ArrayList<WeatherResponse>>()
        cities.onEach {
            weatherCityResponse = weatherCheckCity(it, weatherCityResponse)

        }
        return weatherCityResponse
    }
}