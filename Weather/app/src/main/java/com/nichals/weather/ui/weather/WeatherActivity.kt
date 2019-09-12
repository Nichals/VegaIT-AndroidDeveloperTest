package com.nichals.weather.ui.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nichals.weather.R
import kotlinx.android.synthetic.main.activity_main.*

class WeatherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var model = ViewModelProviders.of(this).get(WeatherViewModel::class.java)
        val linearLayoutManager = LinearLayoutManager(
            this, RecyclerView.VERTICAL,false)
        recyclerview.layoutManager = linearLayoutManager
        model.weather.observe(this, Observer{ weather->
            // Data bind the recycler view
            recyclerview.adapter = WeatherAdapter(weather)
        })

    }
}
