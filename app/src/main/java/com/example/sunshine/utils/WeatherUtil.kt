package com.example.sunshine.utils

object WeatherUtil {


    var values : String = ""
    var WEATHER_ICON_URL : String
    get() = "http://openweathermap.org/img/w/${values}.png"
    set(value) { values = value }
}