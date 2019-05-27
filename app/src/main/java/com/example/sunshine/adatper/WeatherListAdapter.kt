package com.example.sunshine.adatper

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.sunshine.R
import com.example.sunshine.data.vos.WeatherVO
import com.example.sunshine.mvp.presenter.WeatherHomePresenter
import com.example.sunshine.views.holder.BaseViewHolder
import com.example.sunshine.views.holder.BaseWeatherViewHolder
import com.example.sunshine.views.holder.FutureWeatherViewHolder
import com.example.sunshine.views.holder.TodayWeatherViewHolder

class WeatherListAdapter(val listpresenter:WeatherHomePresenter) : BaseAdapter<BaseWeatherViewHolder, WeatherVO>() {

    val TODAY_WEATHER_VIEW = 11
    val FUTURE_WEATHER_VIEW = 12

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): BaseViewHolder<WeatherVO> {
Log.d("View type ", " $viewType")
        val layoutInflater = LayoutInflater.from(viewGroup.getContext())

        when (viewType) {
            TODAY_WEATHER_VIEW -> {
                val itemView = layoutInflater.inflate(R.layout.today_weather_item_view, viewGroup, false)
                return TodayWeatherViewHolder(itemView, listpresenter)
            }
            FUTURE_WEATHER_VIEW -> {
                val itemViewSmall = layoutInflater.inflate(R.layout.item_view_future_weather, viewGroup, false)
                return FutureWeatherViewHolder(itemViewSmall, listpresenter)
            }
        }
        return null!!

    }



    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            TODAY_WEATHER_VIEW
        } else {
            FUTURE_WEATHER_VIEW
        }
    }
}