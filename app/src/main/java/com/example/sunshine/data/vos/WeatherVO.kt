package com.example.sunshine.data.vos

import androidx.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = "weather_table")
data  class WeatherVO(
    @PrimaryKey(autoGenerate = true)
    var weatherId: Int ,

    @Embedded
    var main: MainVO? = null,

    @TypeConverters()
    var weather:  MutableList<WeatherDescVO>? = null,

    @Embedded
    var wind: WindVO? = null,

    @ColumnInfo
    var dt_txt: String = "",

    @ColumnInfo
    var time: String ="",

    @ColumnInfo
    var date: String = ""

)