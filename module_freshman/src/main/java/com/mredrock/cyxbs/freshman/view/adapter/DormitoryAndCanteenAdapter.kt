package com.mredrock.cyxbs.freshman.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.bean.DormitoryAndCanteenMessage
import com.youth.banner.Banner

/**
 * Create by yuanbing
 * on 2019/8/7
 */
class DormitoryAndCanteenAdapter : RecyclerView.Adapter<DormitoryAndCanteenViewHolder>() {
    private var mDormitoryAndCanteenMessage: List<DormitoryAndCanteenMessage> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DormitoryAndCanteenViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
                R.layout.freshman_recycle_item_campus_guidelines, parent, false)
        return DormitoryAndCanteenViewHolder(view)
    }

    override fun getItemCount() = mDormitoryAndCanteenMessage.size

    override fun onBindViewHolder(holder: DormitoryAndCanteenViewHolder, position: Int) {

    }

    fun refreshData(dormitoryAndCanteenMessage: DormitoryAndCanteenMessage) {
//        mDormitoryAndCanteenMessage = dormitoryAndCanteenMessage
        notifyDataSetChanged()
    }
}
class DormitoryAndCanteenViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val mBanner: Banner = view.findViewById(R.id.banner_recycle_item_campus_guidelines_photo)
    val mName: TextView = view.findViewById(R.id.tv_recycle_item_campus_guidelines_place)
    val mDescription: TextView = view.findViewById(R.id.tv_recycle_item_campus_guidelines_description)
}