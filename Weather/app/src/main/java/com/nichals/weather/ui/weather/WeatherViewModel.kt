package com.nichals.weather.ui.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nichals.weather.data.model.WeatherResponse
import com.nichals.weather.data.repository.WeatherRepository

class WeatherViewModel : ViewModel() {
    val cities = listOf("curitiba,br",
        "sao paulo,br",
        "bahia,br",
        "santa catarina,br",
        "minas gerais,br",
        "london,uk")
    val weatherRepository =  WeatherRepository()
    internal val weather : LiveData<ArrayList<WeatherResponse>> = weatherRepository.weatherCheckCitys(cities)

}