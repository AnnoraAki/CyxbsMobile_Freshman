package com.mredrock.cyxbs.freshman.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.common.utils.extensions.setImageFromUrl
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.bean.OnlineActivityText

/**
 * Create by yuanbing
 * on 2019/8/3
 */
class OnlineActivityAdapter() :
        RecyclerView.Adapter<OnlineActivityViewHolder>() {
    private var mActivities: List<OnlineActivityText> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnlineActivityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
                R.layout.freshman_recycle_item_online_activity, parent, false)
        return OnlineActivityViewHolder(view)
    }

    override fun getItemCount() = mActivities.size

    override fun onBindViewHolder(holder: OnlineActivityViewHolder, position: Int) {
        val activity = mActivities[position]
        holder.mActivityName.text = activity.name
        holder.mActivityPoster.setImageFromUrl(activity.photo)

        holder.mJoinNow.setOnClickListener {

        }
    }

    fun refreshData(activities: List<OnlineActivityText>) {
        mActivities = activities
        notifyDataSetChanged()
    }
}

class OnlineActivityViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val mActivityPoster: ImageView = view.findViewById(R.id.iv_recycle_item_online_activity_poster)
    val mActivityName: TextView = view.findViewById(R.id.tv_recycle_item_online_activity_name)
    val mJoinNow: Button = view.findViewById(R.id.btn_recycle_item_online_activity_join_now)
}