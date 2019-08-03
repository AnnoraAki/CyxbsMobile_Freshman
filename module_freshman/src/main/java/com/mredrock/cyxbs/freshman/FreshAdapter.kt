package com.mredrock.cyxbs.freshman

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.freshman.bean.FreshItem
import com.mredrock.cyxbs.freshman.bean.FreshTextItem
import org.jetbrains.anko.find

class FreshAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val ITEM_VIEW_TYPE_HEADER = 0
    private val ITEM_VIEW_TYPE_ITEM = 1
    private val ITEM_VIEW_TYPE_FOOTER = 2

    val data = listOf<FreshTextItem>(
        FreshTextItem("入学必备", "报道必备  军训用品"),
        FreshTextItem("指路重邮", "公交线路 重邮地图 校园风光"),
        FreshTextItem("入学流程", "报道流程"),
        FreshTextItem("校园指引", "宿舍 食堂 快递 数据揭秘"),
        FreshTextItem("线上交流", "老乡群 学院群 线上活动"),
        FreshTextItem("更多功能", "迎新网 重邮小帮手 发现"),
        FreshTextItem("关于我们", "")
        );

    class TextViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val titleView: TextView = view.find(R.id.tv_title)
        val discriptView: TextView = view.find(R.id.tv_discript)
        companion object {
            fun from(parent: ViewGroup): TextViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.freshman_recycle_item_text_item, parent, false)
                return TextViewHolder(view)
            }
        }

    }
    class HeaderViewHolder(view: View): RecyclerView.ViewHolder(view) {
        companion object {
            fun from(parent: ViewGroup): HeaderViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.freshman_recycle_item_header, parent, false)
                return HeaderViewHolder(view)
            }
        }
    }
    class FooterViewHolder(view: View): RecyclerView.ViewHolder(view) {
        companion object {
            fun from(parent: ViewGroup): FooterViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.freshman_recycle_item_footer, parent, false)
                return FooterViewHolder(view)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_ITEM -> TextViewHolder.from(parent)
            ITEM_VIEW_TYPE_HEADER -> HeaderViewHolder.from(parent)
            ITEM_VIEW_TYPE_FOOTER -> FooterViewHolder.from(parent)
            else -> throw ClassCastException("unknown type of viewholder")
        }
    }

    override fun getItemCount(): Int {
        return data.size + 2;
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TextViewHolder -> {
                val item = data[position - 1]
                holder.discriptView.text = item.discript
                holder.titleView.text = item.title
            }
            is HeaderViewHolder -> {}
            is FooterViewHolder -> {}
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> ITEM_VIEW_TYPE_HEADER
            8 -> ITEM_VIEW_TYPE_FOOTER
            else -> ITEM_VIEW_TYPE_ITEM
        }
    }

}