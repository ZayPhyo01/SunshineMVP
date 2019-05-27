package com.example.sunshine.mvp.view

import com.example.sunshine.data.vos.WeatherVO

interface DetailView : BaseView{
    fun showDetail(weatherVO: WeatherVO)
}