package com.example.sunshine.network.data_agent

import android.content.Context
import android.location.LocationManager
import android.util.Log
import com.example.sunshine.data.vos.WeatherVO
import com.example.sunshine.network.response.WeatherResponse
import com.example.sunshine.utils.AppConstant
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitDA : IDataAgent {

    /**
     * get the weather data depending on the lat,lon by using gps service
     *
     */
    override fun loadWeatherList(
        result: (MutableList<WeatherVO>) -> Unit,
        fail: (String) -> Unit,
        lat: Float,
        lon: Float
    ) {

        mWeatherApi.loadWeatherData(AppConstant.API_KEY, lat, lon).enqueue(object : Callback<WeatherResponse> {
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.d("Data agent ","$t")
                fail.invoke("No network connetion")
            }

            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                val responsebody = response.body()
                result.invoke(responsebody!!.list)
            }
        })

    }

    private var mRetrofit: Retrofit
    var mWeatherApi: WeatherApi

    init {

        mRetrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(AppConstant.BASE_URL)
            .build()

        mWeatherApi = mRetrofit.create(WeatherApi::class.java)

    }

    companion object {
        var retrofitDA: RetrofitDA? = null
        fun getInstance(): RetrofitDA {
            if (retrofitDA == null) {
                retrofitDA = RetrofitDA()
            }
            return retrofitDA!!
        }
    }


}