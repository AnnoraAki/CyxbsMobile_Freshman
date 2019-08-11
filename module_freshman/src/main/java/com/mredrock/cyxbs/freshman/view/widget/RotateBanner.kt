package com.mredrock.cyxbs.freshman.view.widget

import android.animation.ObjectAnimator
import android.animation.TimeInterpolator
import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import com.mredrock.cyxbs.common.utils.LogUtils

/**
 * Create by roger
 * on 2019/8/9
 */
class RotateBanner : ViewGroup {
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
        var cParams: MarginLayoutParams? = null

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
                    cl = 0
                    ct = 0
                    cr = width
                    cb = height
                }
                1 -> {
                    cl = (width / 2.07).toInt()
                    ct = (height / 3.6).toInt()

                    cr = cl + cWidth
                    cb = ct + cHeight
                }
                2 -> {
                    cl = (width / 1.29).toInt()
                    ct = (height / 2.36).toInt()
                    cr = cl + cWidth
                    cb = ct + cHeight
                }
                3 -> {
                    cl = (width / 5).toInt()
                    ct = (height / 2.8).toInt()
                    cr = cl + dp2px(100)
                    cb = ct + dp2px(100)
                }
                4 -> {
                    cl = (width / 1.8).toInt()
                    ct = (height / 2.8).toInt()
                    cr = cl + dp2px(100)
                    cb = ct + dp2px(100)

                }


            }
            childView.layout(cl, ct, cr, cb)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val sizeWidth = MeasureSpec.getSize(widthMeasureSpec)
        val sizeHeight = MeasureSpec.getSize(heightMeasureSpec)

        measureChildren(widthMeasureSpec, heightMeasureSpec)
        val view = getChildAt(0)
        setMeasuredDimension(sizeWidth, view.measuredWidth)
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
                1, 2 -> {
                    val animator = ObjectAnimator.ofFloat(childView, View.ROTATION, 0.0f, 359.0f)
                    animator.duration = 2000
                    animator.repeatMode = ValueAnimator.RESTART
                    animator.repeatCount = ValueAnimator.INFINITE
                    animator.interpolator = LinearInterpolator()
                    animator.start()
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