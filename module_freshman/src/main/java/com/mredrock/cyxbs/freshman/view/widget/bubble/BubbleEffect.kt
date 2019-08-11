package com.mredrock.cyxbs.freshman.view.widget.bubble

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.mredrock.cyxbs.common.utils.LogUtils
import kotlin.math.max

/**
 * Create by roger
 * on 2019/8/11
 */
class BubbleEffect : SurfaceView, SurfaceHolder.Callback, Runnable {
    private val cWidth: Int = dp2px(50)
    private val cHeight: Int = dp2px(50)

    private lateinit var mSurfaceHolder: SurfaceHolder
    private  var mCanvas: Canvas? = null
    private var mIsDrawing = false

    //一些属性
    private val list = mutableListOf<Bubble>()
    private var allBubbleCount = 20
    private val addBubbleOnce = 2
    private val addBubbleInterval = 100
    private val refreshTime = 20
    private val moveSpeed = 0.9
    private var startTime = System.currentTimeMillis()
    private var mPaintColor = Color.parseColor("#b3dfdb")

    constructor(ctx: Context) : this(ctx, null) {

    }

    constructor(ctx: Context, attrs: AttributeSet?) : this(ctx, attrs, 0) {
    }

    constructor(ctx: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(ctx, attrs, defStyleAttr) {
        initView()
    }

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {
    }

    override fun surfaceDestroyed(holder: SurfaceHolder?) {
        mIsDrawing = false
    }

    override fun surfaceCreated(holder: SurfaceHolder?) {
        mIsDrawing = true
        Thread(this).start()
    }

    override fun run() {
        while (mIsDrawing) {
            drawSomething()
        }
    }

    private fun initView() {
        mSurfaceHolder = holder
        mSurfaceHolder.addCallback(this)
        setZOrderOnTop(true)
        holder.setFormat(PixelFormat.TRANSPARENT)

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val sizeWidth = MeasureSpec.getSize(widthMeasureSpec)
        val sizeHeight = MeasureSpec.getSize(heightMeasureSpec)

        val expectWidth = if (widthMode == MeasureSpec.EXACTLY) sizeWidth else cWidth
        val expectHeight = if (heightMode == MeasureSpec.EXACTLY) sizeHeight else cHeight
        setMeasuredDimension(expectWidth, expectHeight)
    }

    private fun drawSomething() {

        val t = System.currentTimeMillis()
        mCanvas = mSurfaceHolder.lockCanvas()
        //canvas 清屏
        val paintClear = Paint()
        paintClear.setXfermode(PorterDuffXfermode(PorterDuff.Mode.CLEAR))
        mCanvas?.drawPaint(paintClear)

        manageBubble((System.currentTimeMillis() - t) * moveSpeed.toDouble())

        mSurfaceHolder.unlockCanvasAndPost(mCanvas)
        Thread.sleep(max(refreshTime - (System.currentTimeMillis() - t), 0))
    }

    private fun manageBubble(distance: Double) {
        val iter = list.iterator()
        while (iter.hasNext()) {
            val bubble = iter.next()
            if (bubble.isOut(0, 0, width, height)) {
                iter.remove()
            } else {
                bubble.move(distance)
            }
        }
        for (x in list) {
            drawBubble(mCanvas!!, x, mPaintColor)
        }
        Log.d("roger", "size = " + list.size)



        if (System.currentTimeMillis() - startTime > addBubbleInterval && list.size < allBubbleCount) {
            for (i in 0..addBubbleOnce) {
                if (list.size < allBubbleCount) {
                    list.add(Bubble(randD() * width / 2 + width / 4, height.toDouble(), randD() * 4, (randD() * 140).toInt() + 20))
                }
            }
            startTime = System.currentTimeMillis()
        }

    }

    private fun drawBubble(canvas: Canvas, bubble: Bubble, color: Int) {
        val paint = Paint()
        paint.isAntiAlias
        paint.color = color
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = bubble.r.toFloat()
        paint.alpha = (getAlpha(bubble) * 255).toInt()
        canvas.drawCircle(bubble.x.toFloat(), bubble.y.toFloat(), bubble.r.toFloat(), paint)
    }

    private fun getAlpha(bubble: Bubble): Double {
        return bubble.y / height
    }
    private fun dp2px(value: Int): Int {
        val v = context.resources.displayMetrics.density
        return (v * value + 0.5f).toInt()
    }

}

private fun randD(): Double {
    return (0..1000).random().toDouble() / 1000
}