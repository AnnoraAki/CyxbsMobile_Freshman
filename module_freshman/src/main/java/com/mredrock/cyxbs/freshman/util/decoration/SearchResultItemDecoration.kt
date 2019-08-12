package com.mredrock.cyxbs.freshman.util.decoration

import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.common.BaseApp
import org.jetbrains.anko.dip

class SearchResultItemDecoration(val mDividerWidth: Int) : RecyclerView.ItemDecoration() {
    private lateinit var mDividerPaint: Paint

    private fun initPaint() {
        mDividerPaint = Paint()
        mDividerPaint.style = Paint.Style.STROKE
        mDividerPaint.strokeWidth = BaseApp.context.dip(mDividerWidth).toFloat()

    }
}