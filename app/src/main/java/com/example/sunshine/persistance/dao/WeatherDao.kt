package com.example.sunshine.persistance.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.sunshine.data.vos.WeatherVO
import com.example.sunshine.utils.WeatherTimeUtil
import kotlin.math.abs

@Dao
abstract class WeatherDao {

    @Insert
    abstract fun insert(weatherList: MutableList<WeatherVO>)

    /**
     * @param currentTime for current local time
     * get 5 day weather list by current time
     */
    @Query("Select * from weather_table where time = :currentTime")
    abstract fun getWeather(currentTime: String): LiveData<MutableList<WeatherVO>>

    @Query("Delete from weather_table")
    abstract fun removeAll()

    /**
     * @param id for user tap id
     */
    @Query("Select * from weather_table where weatherId =:id")
    abstract fun getWeatherById(id: Int) : LiveData<WeatherVO>

    fun saveWeatherList(dao: WeatherDao, data: MutableList<WeatherVO>) {
        dao.removeAll()
        var list = ArrayList<WeatherVO>()
        for(weatherList in data)
        {

            //split the time and to get hour from the format of  ## 2019-05-27 06:00:00
            var time = weatherList.dt_txt.split(' ').get(1).split(':').get(0)
            var date = weatherList.dt_txt.split(' ').get(0)
            weatherList.time = time
            weatherList.date = date
            list.add(weatherList)

        }
        dao.insert(list)

    }

    fun getAllWeatherList(weatherDao: WeatherDao):LiveData<MutableList<WeatherVO>>{
        return weatherDao.getWeather(WeatherTimeUtil.getTime())
    }
}