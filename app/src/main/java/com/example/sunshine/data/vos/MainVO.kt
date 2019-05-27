package com.example.sunshine.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class MainVO (
    @ColumnInfo
    val temp : Float,
    @ColumnInfo
    val pressure : Float,
    @ColumnInfo
    val sea_level : Float
)