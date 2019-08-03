package com.mredrock.cyxbs.freshman.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

/**
 * Create by yuanbing
 * on 2019/8/3
 */
abstract class BaseAdapter<I : Any, T : RecyclerView.ViewHolder>(
        @LayoutRes private val layout: Int
) :
        RecyclerView.Adapter<T>() {
    private var mItems: List<I> = listOf()

    override fun getItemCount() = mItems.size

    override fun onBindViewHolder(holder: T, position: Int) {
        onBindViewHolder(holder, mItems[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): T {
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return createViewHolder(view)
    }

    fun refreshData(items: List<I>) {
        mItems = items
        notifyDataSetChanged()
    }

    abstract fun createViewHolder(view: View): T

    abstract fun onBindViewHolder(holder: T, item: I)
}