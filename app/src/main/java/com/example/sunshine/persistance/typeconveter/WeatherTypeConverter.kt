package com.example.sunshine.persistance.typeconveter

import androidx.room.TypeConverter
import com.example.sunshine.data.vos.WeatherDescVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class WeatherTypeConverter {


    @TypeConverter
    fun toString(obj: MutableList<WeatherDescVO>): String {
        val gson = Gson()
        return gson.toJson(obj)
    }

    @TypeConverter
    fun fromString(string : String) : MutableList<WeatherDescVO> {
        val gson = Gson()
        val type = object : TypeToken<MutableList<WeatherDescVO>>() {

        }.type
        return gson.fromJson(string, type)
    }

}