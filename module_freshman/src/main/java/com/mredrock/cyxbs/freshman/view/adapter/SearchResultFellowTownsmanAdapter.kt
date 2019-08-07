package com.mredrock.cyxbs.freshman.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.bean.FellowTownsmanGroupText
import com.mredrock.cyxbs.freshman.util.event.OnFellowTownsmanSearchResultClickEvent
import org.greenrobot.eventbus.EventBus

/**
 * Create by yuanbing
 * on 2019/8/5
 */
class SearchResultFellowTownsmanAdapter : RecyclerView.Adapter<SearchResultFellowTownsmanViewHolder>() {
    private var mFellowTownsmanGroup: List<FellowTownsmanGroupText> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultFellowTownsmanViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
                R.layout.freshman_recycle_item_online_communication_group_search_result, parent, false)
        return SearchResultFellowTownsmanViewHolder(view)
    }

    override fun getItemCount() = mFellowTownsmanGroup.size

    override fun onBindViewHolder(holder: SearchResultFellowTownsmanViewHolder, position: Int) {
        val fellowTownsmanGroup = mFellowTownsmanGroup[position]
        holder.mName.text = fellowTownsmanGroup.name

        holder.itemView.setOnClickListener {
            EventBus.getDefault().post(OnFellowTownsmanSearchResultClickEvent(fellowTownsmanGroup.name))
        }
    }

    fun refreshData(fellowTownsmanGroup: List<FellowTownsmanGroupText>) {
        mFellowTownsmanGroup = fellowTownsmanGroup
        notifyDataSetChanged()
    }
}

class SearchResultFellowTownsmanViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val mName: TextView = view.findViewById(R.id.tv_recycle_item_online_communication_group_search_result)
}