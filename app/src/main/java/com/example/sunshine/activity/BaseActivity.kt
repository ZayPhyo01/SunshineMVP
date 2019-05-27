package com.example.sunshine.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.sunshine.mvp.presenter.BasePresenter
import com.example.sunshine.mvp.view.BaseView

abstract class BaseActivity : AppCompatActivity(),BaseView{
    override fun getContext() : Context {
       return getContext()
    }
}