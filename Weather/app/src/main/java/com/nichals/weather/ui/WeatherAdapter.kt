package com.nichals.weather.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nichals.weather.R
import com.nichals.weather.data.WeatherResponse

class WeatherAdapter(var weatherList: List<WeatherResponse>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return WeatherViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.weather_view, parent, false))
    }

    override fun getItemCount() = weatherList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as WeatherViewHolder ).bind(weatherList[position])

    }
}

class WeatherViewHolder(view: View): RecyclerView.ViewHolder(view){
    var tvName: TextView =view!!.findViewById(R.id.tvName)
    var tvCelsius: TextView =view!!.findViewById(R.id.tvCelsius)
    var tvStatus: TextView =view!!.findViewById(R.id.tvStatus)

    fun bind(item: WeatherResponse){
        tvName.text = item.name
        tvCelsius.text = item.main?.temp.toString()
        tvStatus.text = item.clouds?.all.toString()
    }
}