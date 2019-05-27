package com.example.sunshine.mvp.view

import com.example.sunshine.data.vos.WeatherVO

interface WeatherHomeView : BaseView {
    fun showWeatherList(weatherList : MutableList<WeatherVO>)
    fun hideProgress()
    fun nevigateTo(id : Int)
}