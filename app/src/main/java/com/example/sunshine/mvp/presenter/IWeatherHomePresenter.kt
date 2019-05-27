package com.example.sunshine.mvp.presenter

import androidx.lifecycle.LifecycleOwner

interface IWeatherHomePresenter {
    fun onUiReady(lifecycleOwner: LifecycleOwner,lat:Float,lon:Float)
    fun onTapItem(id : Int)
    fun onRefresh(lifecycleOwner: LifecycleOwner,lat:Float,lon:Float)
}