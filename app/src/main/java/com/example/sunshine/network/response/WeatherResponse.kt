package com.example.sunshine.network.response

import com.example.sunshine.data.vos.WeatherVO

data class WeatherResponse (
    val cod : Int,
    val list : MutableList<WeatherVO>
    )