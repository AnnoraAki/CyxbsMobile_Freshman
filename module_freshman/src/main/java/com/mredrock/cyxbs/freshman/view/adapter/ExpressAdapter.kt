package com.mredrock.cyxbs.freshman.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.common.utils.extensions.setImageFromUrl
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.bean.ExpressMessage

class ExpressAdapter : RecyclerView.Adapter<ExpressViewHolder>() {
    private var mExpress: List<ExpressMessage> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpressViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
                R.layout.freshman_recycle_item_campus_guidelines_single_photo, parent, false)
        return ExpressViewHolder(view)
    }

    override fun getItemCount() = mExpress.size

    override fun onBindViewHolder(holder: ExpressViewHolder, position: Int) {
        val express = mExpress[position]
        holder.mPlace.text = express.title
        holder.mPhoto.setImageFromUrl(express.photo)
        holder.mDescription.text = express.detail
    }

    fun refreshData(express: List<ExpressMessage>) {
        this.mExpress = express
        notifyDataSetChanged()
    }
}

class ExpressViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val mPhoto: ImageView = view.findViewById(R.id.iv_recycle_item_campus_guidelines_single_photo_photo)
    val mPlace: TextView = view.findViewById(R.id.tv_recycle_item_campus_guidelines_single_photo_place)
    val mDescription: TextView = view.findViewById(R.id.tv_recycle_item_campus_guidelines_single_photo_description)
}