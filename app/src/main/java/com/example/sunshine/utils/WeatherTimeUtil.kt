package com.example.sunshine.utils

import java.util.*

//Todo should be object ? or companion
object WeatherTimeUtil {

    val TIME0: String = "00"
    val TIME3: String = "03"
    val TIME6: String = "06"
    val TIME9: String = "09"
    val TIME12: String = "12"
    val TIME15: String = "15"
    val TIME18: String = "18"
    val TIME21: String = "21"
    val TIME24: String = "24"

    /**
     * get the current hour for the current weather hour within a day
     */
    fun getTime(): String {
        val date : Int = Calendar.getInstance().time.hours
        return when (date) {
            in 0..2 -> TIME0
            in 3..5 -> TIME3
            in 6..8 -> TIME6
            in 9..11 -> TIME9
            in 12..14 -> TIME12
            in 15..17 -> TIME15
            in 18..20 -> TIME18
            in 21..23 -> TIME21
            24 -> TIME24
            else -> {
                ""
            }
        }
    }
}