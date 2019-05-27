package com.example.sunshine.views.holder

import android.view.View
import com.bumptech.glide.Glide
import com.example.sunshine.data.vos.WeatherVO
import com.example.sunshine.mvp.presenter.WeatherHomePresenter
import com.example.sunshine.utils.WeatherUtil
import kotlinx.android.synthetic.main.item_view_future_weather.view.*
import kotlinx.android.synthetic.main.today_weather_item_view.view.*
import kotlinx.android.synthetic.main.today_weather_item_view.view.weatherIcon
import java.util.*

class TodayWeatherViewHolder(view: View, val presenter: WeatherHomePresenter) : BaseWeatherViewHolder(view) {

    lateinit var data:WeatherVO
    override fun onClick(v: View?) {
        presenter.onTapItem(data.weatherId)
    }

    override fun bind(bindData: WeatherVO) {
        data = bindData
        WeatherUtil.WEATHER_ICON_URL = bindData.weather!!.get(0).icon
        itemView.pressure.setText("p : ${bindData.main!!.pressure}")
        Glide.with(itemView)
            .load(WeatherUtil.WEATHER_ICON_URL)
            .into(itemView.weatherIcon)
        itemView.weatherTemp.setText(" ${bindData.main!!.temp}")
        itemView.weatherStateToday.setText(bindData.weather!!.get(0).main)
        var timeToday = Calendar.getInstance().time
        itemView.currentDate.setText("Today ,${timeToday.month+1}  ${timeToday.date}")



    }
}