package com.mredrock.cyxbs.freshman.view.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView

/**
 * Create by roger
 * on 2019/8/5
 */

class NonScrollExpandableListView : ExpandableListView {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {}

    override fun setAdapter(adapter: ExpandableListAdapter?) {
        super.setAdapter(adapter)
    }

    override fun setOnChildClickListener(onChildClickListener: OnChildClickListener) {
        super.setOnChildClickListener(onChildClickListener)
    }

    override fun expandGroup(groupPos: Int) : Boolean {
        return super.expandGroup(groupPos)
    }

    override fun expandGroup(groupPos: Int, animate: Boolean) : Boolean {
        return super.expandGroup(groupPos, animate)
    }

    override fun isGroupExpanded(groupPosition: Int): Boolean {
        return super.isGroupExpanded(groupPosition)
    }

    public override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val heightMeasureSpec_custom = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE shr 2, MeasureSpec.AT_MOST)
        super.onMeasure(widthMeasureSpec, heightMeasureSpec_custom)
        val params = layoutParams
        params.height = measuredHeight
    }
}