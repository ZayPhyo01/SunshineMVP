package com.example.sunshine.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.sunshine.data.model.WeatherModel
import com.example.sunshine.data.vos.WeatherVO
import com.example.sunshine.mvp.view.WeatherHomeView
import retrofit2.http.FormUrlEncoded

class WeatherHomePresenter :
    BasePresenter<WeatherHomeView, WeatherModel>(), IWeatherHomePresenter {

    override fun onRefresh(lifecycleOwner: LifecycleOwner,lat:Float,lon:Float) {
        mModel.getWeather( {
            mView.showError(it)
        }, lat, lon).observe(lifecycleOwner,object :Observer<MutableList<WeatherVO>>{

            override fun onChanged(t: MutableList<WeatherVO>?) {
                val debut = t
                mView.showWeatherList(t!!)
                mView.hideProgress()
            }
        })
    }

    override fun initModel(): WeatherModel {
        return WeatherModel
    }


    override fun onUiReady(lifecycleOwner: LifecycleOwner,lat: Float, lon: Float) {
        mModel.getWeather( {
            mView.showError(it)
        }, lat, lon).observe(lifecycleOwner,object :Observer<MutableList<WeatherVO>>{

            override fun onChanged(t: MutableList<WeatherVO>?) {
                 val debut = t
                mView.showWeatherList(t!!)
            }
        })
    }

    override fun onTapItem(id: Int) {
        mView.nevigateTo(id)

    }
}