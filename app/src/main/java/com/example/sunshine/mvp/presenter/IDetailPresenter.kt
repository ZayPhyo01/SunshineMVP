package com.example.sunshine.mvp.presenter

import androidx.lifecycle.LifecycleOwner

interface IDetailPresenter {
    fun onUiReady(lifecycleOwner: LifecycleOwner,id : Int)
}