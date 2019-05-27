package com.example.sunshine.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.sunshine.R
import com.example.sunshine.data.vos.WeatherVO
import com.example.sunshine.mvp.presenter.DetailPresenter
import com.example.sunshine.mvp.view.DetailView
import com.example.sunshine.utils.AppConstant
import com.example.sunshine.utils.WeatherUtil
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity(),DetailView{

    lateinit var mPresenter : DetailPresenter
    override fun showDetail(weatherVO: WeatherVO) {
        WeatherUtil.WEATHER_ICON_URL =weatherVO.weather!!.get(0).icon

        detailDesc.setText(weatherVO.weather!!.get(0).description)
        detailDate.setText(" ${weatherVO.date}")
        detailPressure.setText("Pressure : ${weatherVO.main!!.pressure}")
        detailSeaLevel.setText("Sea level : ${weatherVO.main!!.sea_level}")
        detailWind.setText("Wind : ${weatherVO.wind}")
        detailState.setText(weatherVO.weather!!.get(0).main)
        detailTmp.setText(" ${weatherVO.main!!.temp}")
        Glide.with(this)
            .load(WeatherUtil.WEATHER_ICON_URL)
            .into(detailIcon)

    }


    companion object{
        fun newIntent (context: Context): Intent {
            var intent = Intent(context,DetailActivity::class.java)
            return intent
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        Log.d("Detail activity ","work")
        var id = intent.extras.getInt(AppConstant.WEATHER_ID)
        Log.d("Weather tap id "," $id")
        mPresenter = ViewModelProviders.of(this).get(DetailPresenter::class.java)
        mPresenter.initView(this)
        mPresenter.onUiReady(this,id)

    }



    override fun showError(message: String) {

    }
}