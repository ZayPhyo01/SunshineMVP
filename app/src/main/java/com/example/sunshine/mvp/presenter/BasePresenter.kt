package com.example.sunshine.mvp.presenter

import androidx.lifecycle.ViewModel
import com.example.sunshine.data.model.BaseModel
import com.example.sunshine.mvp.view.BaseView

abstract class BasePresenter<V : BaseView , T : BaseModel>() : ViewModel() {
    var mModel : T
    lateinit var mView : V

    init {


        mModel = initModel()
    }

    fun initView(view : V){
        mView = view
    }

    abstract fun initModel() : T


}