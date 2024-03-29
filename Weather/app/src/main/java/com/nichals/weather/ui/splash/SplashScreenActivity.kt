package com.nichals.weather.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nichals.weather.R
import com.nichals.weather.ui.weather.WeatherActivity
import java.util.*
import kotlin.concurrent.schedule

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Timer().schedule(2000) {
            startActivity(Intent(applicationContext, WeatherActivity::class.java))
        }
    }
}
