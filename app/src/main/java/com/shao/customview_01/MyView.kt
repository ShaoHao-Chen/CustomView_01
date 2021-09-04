package com.shao.customview_01

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class MyView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val mPaint0: Paint = Paint()
    private val mPaint1: Paint = Paint()
    private val mPaint2: Paint = Paint()
    private var initFlag: Boolean = false
    private var viewWidth: Int = 0
    private var viewHeight: Int = 0

    init {
        setBackgroundColor(Color.BLACK)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (!initFlag) {
            initialize()
            initFlag = true
        }

        canvas?.drawCircle(viewWidth / 6f * 1f, viewHeight / 8f, viewHeight / 16f, mPaint0)
        canvas?.drawCircle(viewWidth / 6f * 3f, viewHeight / 8f, viewHeight / 16f, mPaint1)
        canvas?.drawCircle(viewWidth / 6f * 5f, viewHeight / 8f, viewHeight / 16f, mPaint2)

        canvas?.drawLine(
            viewWidth / 6f * 0f,
            viewHeight / 8f * 2f,
            viewWidth / 6f * 2f,
            viewHeight / 8f * 3f,
            mPaint0
        )
        canvas?.drawLine(
            viewWidth / 6f * 2f,
            viewHeight / 8f * 2f,
            viewWidth / 6f * 4f,
            viewHeight / 8f * 3f,
            mPaint1
        )
        canvas?.drawLine(
            viewWidth / 6f * 4f,
            viewHeight / 8f * 2f,
            viewWidth / 6f * 6f,
            viewHeight / 8f * 3f,
            mPaint2
        )

        canvas?.drawRect(
            viewWidth / 6f * 0f + 10,
            viewHeight / 8f * 4f,
            viewWidth / 6f * 2f - 10,
            viewHeight / 8f * 5f,
            mPaint0
        )
        canvas?.drawRect(
            viewWidth / 6f * 2f + 10,
            viewHeight / 8f * 4f,
            viewWidth / 6f * 4f - 10,
            viewHeight / 8f * 5f,
            mPaint1
        )
        canvas?.drawRect(
            viewWidth / 6f * 4f + 10,
            viewHeight / 8f * 4f,
            viewWidth / 6f * 6f - 10,
            viewHeight / 8f * 5f,
            mPaint2
        )
        canvas?.drawText("Red",
            viewWidth / 6f * 0f + 10,
            viewHeight / 8f * 6f,
            mPaint0
        )
        canvas?.drawText("Green",
            viewWidth / 6f * 2f + 10,
            viewHeight / 8f * 6f,
            mPaint1
        )

        canvas?.drawText("Blue",
            viewWidth / 6f * 4f + 10,
            viewHeight / 8f * 6f,
            mPaint2
        )
    }

    private fun initialize() {
        viewWidth = width
        viewHeight = height

        mPaint0.color = Color.RED
        mPaint0.strokeWidth = 30F           //外框寬度
        mPaint0.style = Paint.Style.STROKE  //僅有外框
        mPaint0.textSize=100f

        mPaint1.color = Color.GREEN
        mPaint1.strokeWidth = 30F           //外框寬度
        mPaint1.style = Paint.Style.FILL    //內部填滿
        mPaint1.textSize=125f

        mPaint2.color = Color.BLUE
        mPaint2.strokeWidth = 30F                   //外框寬度
        mPaint2.style = Paint.Style.FILL_AND_STROKE //內部填滿 + 外框
        mPaint2.textSize=150f
    }

}