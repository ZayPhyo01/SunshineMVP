package com.example.sunshine.data.model

import android.content.Context
import androidx.room.Database
import com.example.sunshine.network.data_agent.RetrofitDA
import com.example.sunshine.persistance.WeatherDatabase

open class BaseModel {
   protected var mDataAgent : RetrofitDA?=null
   protected var mWeatherDatabase: WeatherDatabase?=null


}