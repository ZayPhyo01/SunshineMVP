package com.example.sunshine.data.model

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.sunshine.data.vos.WeatherVO
import com.example.sunshine.network.data_agent.RetrofitDA
import com.example.sunshine.persistance.WeatherDatabase
import com.example.sunshine.persistance.dao.WeatherDao

object WeatherModel : BaseModel(), IWeatherModel {

    override fun getWeatherById(id: Int): LiveData<WeatherVO> {
         return mWeatherDao!!.getWeatherById(id)
    }

    lateinit var mWeatherDao:WeatherDao

    fun initModel(context: Context){
        mDataAgent = RetrofitDA.getInstance()
        mWeatherDatabase = WeatherDatabase.getDatabase(context)
        mWeatherDao = mWeatherDatabase!!.getWeatherDao()
    }

    override fun getWeather(fail: (String) -> Unit, lat: Float, lon: Float): LiveData<MutableList<WeatherVO>> {

        Log.d("Call "," get weather")
        mDataAgent!!.loadWeatherList({
             var logd = it
             mWeatherDao.saveWeatherList(mWeatherDao,it)

        }, {
            fail.invoke(it)
            Log.d("response ","fail")
        }, lat, lon)

        return mWeatherDao.getAllWeatherList(mWeatherDao)
    }


}