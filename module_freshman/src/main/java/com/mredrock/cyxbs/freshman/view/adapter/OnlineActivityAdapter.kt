package com.mredrock.cyxbs.freshman.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.bean.OnlineActivityText
import kotlinx.android.synthetic.main.freshman_recycle_item_online_activity.*

/**
 * Create by yuanbing
 * on 2019/8/3
 */
class OnlineActivityAdapter() :
        RecyclerView.Adapter<OnlineActivityViewHolder>() {
    private val activities: List<OnlineActivityText> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnlineActivityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
                R.layout.freshman_recycle_item_online_activity, parent, false)
        return OnlineActivityViewHolder(view)
    }

    override fun getItemCount() = activities.size

    override fun onBindViewHolder(holder: OnlineActivityViewHolder, position: Int) {
        val activity = activities[position]
        holder.mActivityName.text = activity.name

        holder.mJoinNow.setOnClickListener {
            // TODO
        }
    }
}

class OnlineActivityViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val mActivityPoster = view.findViewById<ImageView>(R.id.iv_recycle_item_online_activity_poster)
    val mActivityName = view.findViewById<TextView>(R.id.tv_recycle_item_online_activity_name)
    val mJoinNow = view.findViewById<Button>(R.id.btn_recycle_item_online_activity_join_now)
}