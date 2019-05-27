package com.example.sunshine.persistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.sunshine.data.vos.WeatherVO
import com.example.sunshine.persistance.dao.WeatherDao
import com.example.sunshine.persistance.typeconveter.WeatherTypeConverter


@Database(entities = arrayOf(WeatherVO::class)  ,version = 14)
@TypeConverters(WeatherTypeConverter::class)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun getWeatherDao(): WeatherDao

    companion object {
        private var INSTANCE: WeatherDatabase? = null
        fun getDatabase(context: Context): WeatherDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder<WeatherDatabase>(context, WeatherDatabase::class.java, "WeatherDabase.DB")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()

            }
            return INSTANCE!!
        }
    }


}