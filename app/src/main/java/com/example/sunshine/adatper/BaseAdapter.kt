package com.example.sunshine.adatper

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.sunshine.views.holder.BaseViewHolder


abstract class BaseAdapter <T : BaseViewHolder<W>, W : Any>: RecyclerView.Adapter<BaseViewHolder<W>>() {

    protected var mData: MutableList<W> = ArrayList()


    val items: List<W>
        get() {
            val data = mData
            return data ?: ArrayList()
        }

    init {
        mData = ArrayList()

    }

    override fun onBindViewHolder(holder: BaseViewHolder<W>, position: Int) {
         Log.d("position "," $position")
         holder.bind(mData.get(position))
    }



    override fun getItemCount(): Int {
        return mData.size
    }

    fun setNewData(newData: MutableList<W>) {
        mData = newData
        notifyDataSetChanged()
    }

    fun appendNewData(newData: List<W>) {
        mData.addAll(newData)
        notifyDataSetChanged()
    }

    fun getItemAt(position: Int): W? {
        return if (position < mData.size - 1) mData[position] else null

    }

    fun removeData(data: W) {
        mData.remove(data)
        notifyDataSetChanged()
    }

    fun addNewData(data: W) {
        mData.add(data)
        notifyDataSetChanged()
    }

    fun clearData() {
        mData = ArrayList()
        notifyDataSetChanged()
    }
}
