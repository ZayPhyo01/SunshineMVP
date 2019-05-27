package com.example.sunshine.activity

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sunshine.R
import com.example.sunshine.adatper.WeatherListAdapter
import com.example.sunshine.data.vos.WeatherVO
import com.example.sunshine.mvp.presenter.WeatherHomePresenter
import com.example.sunshine.mvp.view.WeatherHomeView
import com.example.sunshine.network.data_agent.RetrofitDA
import com.example.sunshine.utils.AppConstant
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : BaseActivity(), WeatherHomeView {
    override fun nevigateTo(id: Int) {
        Log.d("nevigate id "," $id")
        var intent = DetailActivity.newIntent(this)
        intent.putExtra(AppConstant.WEATHER_ID, id)
        startActivity(intent)
    }

    override fun hideProgress() {
        swipeRefresh.isRefreshing = false
    }


    lateinit var mWeatherAdapter: WeatherListAdapter
    lateinit var mWeatherPresener: WeatherHomePresenter
    override fun showError(message: String) {

    }


    override fun showWeatherList(weatherList: MutableList<WeatherVO>) {
        Log.d(javaClass.name, " size ${weatherList.size}")
        mWeatherAdapter.setNewData(weatherList)
    }

    lateinit var locationManager: LocationManager
    val MY_PERMISSIONS_REQUEST_LOCATION: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mWeatherPresener = ViewModelProviders.of(this).get(WeatherHomePresenter::class.java)
        mWeatherAdapter = WeatherListAdapter(mWeatherPresener)
        var layoutManager = LinearLayoutManager(this)
        weatherList.layoutManager = layoutManager
        weatherList.adapter = mWeatherAdapter
        mWeatherPresener.initView(this)
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            // Permission is not granted
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                MY_PERMISSIONS_REQUEST_LOCATION
            )

        }

        val location: Location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
        val lat = location.latitude
        val lon = location.longitude
        Log.d("Lat ", "$lat")
        Log.d("Lon", "$lon")
        mWeatherPresener.onUiReady(this, lat.toFloat(), lon.toFloat())

        swipeRefresh.setOnRefreshListener {
            mWeatherPresener.onRefresh(this, lat.toFloat(), lon.toFloat())
        }
    }


}
