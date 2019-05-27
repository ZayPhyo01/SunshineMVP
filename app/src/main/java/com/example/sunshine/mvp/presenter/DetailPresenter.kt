package com.example.sunshine.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.sunshine.data.model.WeatherModel
import com.example.sunshine.data.vos.WeatherVO
import com.example.sunshine.mvp.view.DetailView

class DetailPresenter : BasePresenter<DetailView,WeatherModel>(),IDetailPresenter {

    override fun onUiReady(lifecycleOwner: LifecycleOwner, id: Int) {
    mModel.getWeatherById(id).observe(lifecycleOwner,object :Observer<WeatherVO>{
        override fun onChanged(t: WeatherVO?) {
             mView.showDetail(t!!)
        }
    })
    }

    override fun initModel(): WeatherModel {
         return WeatherModel
    }


}