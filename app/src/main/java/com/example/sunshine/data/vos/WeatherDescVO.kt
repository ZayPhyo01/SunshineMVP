package com.example.sunshine.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class WeatherDescVO(
    @ColumnInfo
    val id: Int,
    @ColumnInfo
    val main : String,
    @ColumnInfo
    val description : String,
    @ColumnInfo
    val icon : String
    )