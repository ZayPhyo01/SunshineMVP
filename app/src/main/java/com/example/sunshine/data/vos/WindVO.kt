package com.example.sunshine.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class WindVO (
    @ColumnInfo
    val speed:Float
)