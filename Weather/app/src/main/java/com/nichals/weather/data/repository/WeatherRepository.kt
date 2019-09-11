package com.nichals.weather.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nichals.weather.data.WeatherResponse
import com.nichals.weather.data.network.WeatherApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherRepository {

    var weatherResponse = MutableLiveData<ArrayList<WeatherResponse>>()
    fun weatherCheck(): LiveData<ArrayList<WeatherResponse>> {

        WeatherApi().getCurrentWeatherDataLatLong("-25.441105","-49.276855","dc0f9a0be7aea7f236131463dab3a19f").enqueue(object :
            Callback<WeatherResponse> {

            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                var weather = response.body() as WeatherResponse
                weatherResponse.add(weather)
                Log.e("retorno",weatherResponse.value.toString() )
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.e("retorno",t.message )
            }
        })

        return weatherResponse
    }


    fun <T> MutableLiveData<ArrayList<T>>.add(valueToAdd: T) {
        val value = this.value ?: arrayListOf()
        value.add(valueToAdd)
        this.value = value
    }
}