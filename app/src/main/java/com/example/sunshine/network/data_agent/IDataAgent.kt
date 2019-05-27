package com.example.sunshine.network.data_agent

import android.content.Context
import com.example.sunshine.data.vos.WeatherVO

interface IDataAgent {
    fun loadWeatherList(result: (MutableList<WeatherVO>) -> Unit, fail: (String) -> Unit, lat: Float, lon: Float)
}