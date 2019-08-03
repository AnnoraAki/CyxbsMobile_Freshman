package com.mredrock.cyxbs.freshman.view.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorRes

/**
 * Create by yuanbing
 * on 2019/8/2
 */
class Histogram @JvmOverloads constructor(context: Context, attr: AttributeSet? = null,
                                          defStyleAttr: Int = 0, defStyleRes: Int = 0) :
        View(context, attr, defStyleAttr, defStyleRes) {
    // 写死了，只画三个柱子
    private var mHeight: Int = 0
    private var mWidth: Int  = 0

    private var mTotal: Int = 1  // 总高度
    private var mTitle: String = ""  // 图表的标题
    private var mItemWidth: Int = 0  // 每个Item的宽度
    private var mXYWidth: Int = 1  // 坐标轴的粗细
    private var mOY: Int = 0  // 原点的y
    private var mOX: Int = 0  // 原点的x
    private var mY: Int = 0  // Y轴的高度
    private var mX: Int = 0  // X轴的长度
    private var mXYToBottom: Int = 0
    private var mXYToLeft: Int = 0
    private lateinit var mXYPaint: Paint


    private var mItems: Array<HistogramItem>? = null

    init {

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        if (widthMode == heightMode && widthMode == MeasureSpec.AT_MOST) {

        }
    }

    override fun onDraw(canvas: Canvas?) {
        drawXY(canvas)

    }

    fun setMax(max: Int) { mTotal = max }

    fun addItems(items: Array<HistogramItem>) {
        mItems = items

    }

    /**
     * 画出坐标轴以及相关的标注
     */
    private fun drawXY(canvas: Canvas?) {
        canvas?.drawLine(mOX.toFloat(), mOY.toFloat(), mOX.toFloat(), mOY.toFloat() + mY, mXYPaint)
    }
}

data class HistogramItem(
        val value: Int,
        val name: String,
        @ColorRes val color: Int
)