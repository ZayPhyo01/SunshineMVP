package com.example.sunshine.views.holder

import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.example.sunshine.data.vos.WeatherVO
import com.example.sunshine.mvp.presenter.WeatherHomePresenter
import com.example.sunshine.utils.AppConstant
import com.example.sunshine.utils.WeatherUtil
import kotlinx.android.synthetic.main.item_view_future_weather.view.*

class FutureWeatherViewHolder(view: View,val presenter:WeatherHomePresenter) : BaseWeatherViewHolder(view) {

    lateinit var data : WeatherVO

    override fun bind(bindData: WeatherVO) {
        data = bindData
        Log.d("bindData "," $bindData")
        WeatherUtil.WEATHER_ICON_URL = bindData.weather!!.get(0).icon

            itemView.weatherState.setText(bindData.weather!!.get(0).main)
        Glide.with(itemView)
            .load(WeatherUtil.WEATHER_ICON_URL)
            .into(itemView.weatherIcon)
        itemView.tem.setText(bindData.main!!.temp.toString())
        itemView.date.setText(bindData.dt_txt)


    }

    override fun onClick(v: View?) {
        presenter.onTapItem(data.weatherId)
           }
}