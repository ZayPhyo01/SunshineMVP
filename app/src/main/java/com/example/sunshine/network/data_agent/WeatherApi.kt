package com.example.sunshine.network.data_agent


import com.example.sunshine.data.vos.WeatherVO
import com.example.sunshine.network.response.WeatherResponse
import com.example.sunshine.utils.AppConstant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET(AppConstant.FORECAST_URL)
    fun loadWeatherData(
        @Query("appid") key: String,
        @Query("lat") lat: Float,
        @Query("lon") lon: Float
    ) : Call<WeatherResponse>
}