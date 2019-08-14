package com.mredrock.cyxbs.freshman.view.widget

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.ViewGroup
import com.mredrock.cyxbs.common.utils.LogUtils

/**
 * Create by roger
 * on 2019/8/9
 */
class EnvelopViewGroup : ViewGroup {

    private val radiusWidth = dp2px(70)
    private val radiusHeight = dp2px(25)

    private val duration: Long = 1500

    private val secDuration: Long = 1000

    constructor(ctx: Context) : this(ctx, null) {

    }

    constructor(ctx: Context, attrs: AttributeSet?) : this(ctx, attrs, 0) {
    }

    constructor(ctx: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(ctx, attrs, defStyleAttr) {

    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val cCount = childCount
        var cWidth = 0
        var cHeight = 0

        for (i in 0 until cCount) {
            val childView = getChildAt(i)
            cWidth = childView.measuredWidth
            cHeight = childView.measuredHeight
            val centerX = width / 2
            val centerY = height / 2
            var cl = 0
            var ct = 0
            var cr = 0
            var cb = 0
            when (i) {
                0 -> {
                    cl = centerX - radiusWidth
                    ct = centerY - radiusHeight
                    cr = ((centerX + radiusWidth).toDouble() * 0.99).toInt()
                    cb = centerY + radiusHeight
                }
                1 -> {
                    val mTop = dp2px(40)
                    val mLR = dp2px(25)
                    val mBottom = dp2px(110)
                    val marginWidth = width - mLR * 2
                    val marginHeight = height - mBottom - mTop
                    val mRatio = marginHeight.toDouble() / marginWidth
                    val cRatio = 463.toDouble() / 273
                    if (mRatio > cRatio) {
                        cl = mLR
                        cr = width - mLR
                        ct = mTop
                        cb = (mTop + cRatio * marginWidth).toInt()
                    } else {
                        ct = mTop
                        cb = height - mBottom
                        cl = width / 2 - (marginHeight / cRatio).toInt() / 2
                        cr = width - cl
                    }
                }
                2 -> {
                    cl = centerX - radiusWidth
                    ct = centerY - radiusHeight
                    cr = centerX + radiusWidth
                    cb = centerY + radiusHeight
                }
                3 -> {
                    cl = centerX - radiusWidth
                    ct = centerY - radiusHeight
                    cr = cl + cWidth
                    cb = ct + cHeight
                }
                4 -> {
                    cr = centerX + radiusWidth
                    ct = centerY - radiusHeight
                    cl = cr - cWidth
                    cb = ct + cHeight
                }
                5 -> {
                    cl = centerX - radiusWidth
                    cb = centerY + radiusHeight
                    cr = cl + cWidth
                    ct = cb - cHeight
                }
                6 -> {
                    cr = centerX + radiusWidth
                    cb = centerY + radiusHeight
                    cl = cr - cWidth
                    ct = cb - cHeight
                }
                7 -> {
                    cl = (width - cWidth) / 2
                    ct = height * 6 / 7
                    cr = cl + cWidth
                    cb = ct + cHeight
                }


            }
            childView.layout(cl, ct, cr, cb)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val sizeWidth = MeasureSpec.getSize(widthMeasureSpec)
        val sizeHeight = MeasureSpec.getSize(heightMeasureSpec)

        measureChildren(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(sizeWidth, sizeHeight)

    }

    fun openAnimation() {

        val cCount = childCount
        var cWidth = 0
        var cHeight = 0
        for (i in 0 until cCount) {
            val childView = getChildAt(i)
            cWidth = childView.measuredWidth
            cHeight = childView.measuredHeight
            val centerX = width / 2
            val centerY = height / 2
            var cl = 0
            var ct = 0
            var cr = 0
            var cb = 0
            when (i) {
                0 -> {
                    val ratioX = width / cWidth.toDouble()
                    val ratioY = height / cHeight.toDouble()
                    childView.animate().scaleX(ratioX.toFloat()).scaleY(ratioY.toFloat()).setDuration(duration).start()

                }

                1 -> {
                    childView.animate().alpha(1F).setDuration(secDuration).setStartDelay(duration).start()
                }


                2 -> {
                    val ratioX = width / cWidth.toDouble()
                    val ratioY = height / cHeight.toDouble()
                    childView.animate().scaleX(ratioX.toFloat()).scaleY(ratioY.toFloat()).setDuration(duration).start()
                }


                3 -> {
                    cl = centerX - radiusWidth
                    ct = centerY - radiusHeight
                    cr = cl + cWidth
                    cb = ct + cHeight
                    childView.animate().translationX(-(cl).toFloat()).translationY(-(ct).toFloat()).setDuration(duration).start()
                }
                4 -> {
                    cr = centerX + radiusWidth
                    ct = centerY - radiusHeight
                    cl = cr - cWidth
                    cb = ct + cHeight
                    childView.animate().translationX((width - cr).toFloat()).translationY(-(ct).toFloat()).setDuration(duration).start()

                }
                5 -> {
                    cl = centerX - radiusWidth
                    cb = centerY + radiusHeight
                    cr = cl + cWidth
                    ct = cb - cHeight
                    childView.animate().translationX(-(cl).toFloat()).translationY((height - cb).toFloat()).setDuration(duration).start()


                }
                6 -> {
                    cr = centerX + radiusWidth
                    cb = centerY + radiusHeight
                    cl = cr - cWidth
                    ct = cb - cHeight
                    childView.animate().translationX((width - cr).toFloat()).translationY((height - cb).toFloat()).setDuration(duration).start()
                }
                7 -> {
                    childView.animate().alpha(1F).setDuration(secDuration).setStartDelay(duration).start()
                }


            }
        }
    }

    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MarginLayoutParams(context, attrs)
    }

    fun dp2px(value: Int): Int {
        val v = context.resources.displayMetrics.density
        return (v * value + 0.5f).toInt()
    }
}
