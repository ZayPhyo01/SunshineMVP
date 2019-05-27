package com.example.sunshine

import android.app.Application
import com.example.sunshine.data.model.WeatherModel

class WeatherApp : Application() {

    override fun onCreate() {
        super.onCreate()
        WeatherModel.initModel(applicationContext)
    }
}