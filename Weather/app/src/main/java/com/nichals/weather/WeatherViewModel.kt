package com.nichals.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nichals.weather.data.Weather
import com.nichals.weather.data.WeatherResponse
import com.nichals.weather.data.repository.WeatherRepository

class WeatherViewModel : ViewModel() {
    internal val weather : LiveData<ArrayList<WeatherResponse>> = WeatherRepository().weatherCheck()

    init {

    }

}