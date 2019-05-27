package com.example.sunshine.data.model

import androidx.lifecycle.LiveData
import com.example.sunshine.data.vos.WeatherVO

interface IWeatherModel {
    fun getWeather( fail: (String) -> Unit, lat: Float, lon: Float) : LiveData<MutableList<WeatherVO>>
    fun getWeatherById(id : Int):LiveData<WeatherVO>
}