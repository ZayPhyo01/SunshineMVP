package com.example.sunshine.mvp.view

import android.content.Context

interface BaseView {
    fun getContext() : Context
    fun showError(message : String)
}