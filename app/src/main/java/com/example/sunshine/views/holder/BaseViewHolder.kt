package com.example.sunshine.views.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<S : Any>(view : View):RecyclerView.ViewHolder(view), View.OnClickListener {


    protected var bindData : S?=null

    init {
        view.setOnClickListener(this)
    }


    abstract fun bind(bindData : S)
}