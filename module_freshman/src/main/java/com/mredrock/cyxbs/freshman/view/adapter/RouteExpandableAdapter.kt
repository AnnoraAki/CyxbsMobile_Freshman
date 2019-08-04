package com.mredrock.cyxbs.freshman.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.bean.GroupData
import kotlinx.android.synthetic.main.freshman_list_item_group.view.*
import kotlinx.android.synthetic.main.freshman_list_item_route_multi.*
import kotlinx.android.synthetic.main.freshman_list_item_route_multi.view.*
import kotlinx.android.synthetic.main.freshman_list_item_route_normal.*
import kotlinx.android.synthetic.main.freshman_list_item_route_normal.view.*
import org.jetbrains.anko.find

/**
 * Create by roger
 * on 2019/8/4
 */
class RouteExpandableAdapter(private val context: Context, val list: List<GroupData>) : BaseExpandableListAdapter() {
    override fun getGroup(groupPosition: Int): Any {
        return list[groupPosition].title
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return false
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        if (convertView == null) {
            val inflater = this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.freshman_list_item_group, null)
        }
        convertView!!.tv_campus_map_group.text = getGroup(groupPosition) as String

        return convertView!!

//        var holder: GroupHolder
//        var retView: View
//
//        if (convertView == null) {
//            retView = LayoutInflater.from(parent?.context).inflate(R.layout.freshman_list_item_group, parent, false)
//            holder = GroupHolder()
//            holder.tvGroupName = retView.find(R.id.tv_campus_map_group)
//            retView.setTag(holder)
//        } else {
//            holder = convertView.tag as GroupHolder
//            retView = convertView
//        }
//        holder.tvGroupName?.text = list[groupPosition].title
//
//        return retView
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return list[groupPosition].list.size
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return list[groupPosition].list[childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        if (convertView == null) {
            val inflater = this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            if (list[groupPosition].list.size > 1) {
                convertView = inflater.inflate(R.layout.freshman_list_item_route_multi, null)
                convertView!!.tv_recycle_item_campus_map_multi_content.text =  list[groupPosition].list[childPosition]
                convertView!!.tv_recycle_item_campus_map_multi_title.text = "线路" + childPosition
            } else {
                convertView = inflater.inflate(R.layout.freshman_list_item_route_normal, null)
                convertView!!.tv_recycle_item_campus_map_normal.text = list[groupPosition].list[childPosition]
            }

        }

        return convertView!!


//        var retView: View
//        var holder: ChildHold
//        if (convertView == null) {
//
//            if (list[groupPosition].list.size > 1) {
//                holder = ChildHoldMulti()
//                retView = LayoutInflater.from(parent?.context).inflate(R.layout.freshman_list_item_route_multi, parent, false)
//            } else {
//                holder = ChildHoldNormal()
//                retView = LayoutInflater.from(parent?.context).inflate(R.layout.freshman_list_item_route_normal, parent, false)
//            }
//            retView.setTag(holder)
//        } else {
//            if (list[groupPosition].list.size > 1) {
//                holder = convertView.tag as ChildHoldMulti
//            } else {
//                holder = convertView.tag as ChildHoldNormal
//            }
//            retView = convertView
//        }
//        if (holder is ChildHoldNormal) {
//            holder.tvChildContent?.text = list[groupPosition].list[childPosition]
//        } else if (holder is ChildHoldMulti) {
//            holder.tvChildContent?.text = list[groupPosition].list[childPosition]
//            holder.tvChildTitle?.text = list[groupPosition].title
//
//        }
//
//        return retView
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return list.size
    }

//    class GroupHolder() {
//        var tvGroupName: TextView? = null
//    }
//    class ChildHoldNormal() : ChildHold() {
//        var tvChildContent: TextView? = null
//    }
//    class ChildHoldMulti() : ChildHold() {
//        var tvChildContent: TextView? = null
//        var tvChildTitle: TextView? = null
//
//    }
//    abstract class ChildHold
}