package com.basic.pinchzoomlayoutsample

import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.max
import kotlin.math.min


class MainActivity : AppCompatActivity() {
    private lateinit var mScaleGestureDetector: ScaleGestureDetector
    private var mScaleFactor = 1.0f
    private lateinit var imgAndroid: ImageView
    private lateinit var relativeLayout: RelativeLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializing the ImageVIew and GestureDetector
        imgAndroid = findViewById(R.id.img_android)
        relativeLayout = findViewById(R.id.relative_layout)
        mScaleGestureDetector = ScaleGestureDetector(this, ScaleListener())
    }

    // When touched, GestureDetector records the motion event
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        mScaleGestureDetector.onTouchEvent(event)
        return true
    }

    // Zooming in and out in a bounded range
    private inner class ScaleListener: ScaleGestureDetector.SimpleOnScaleGestureListener(){
        override fun onScale(detector: ScaleGestureDetector?): Boolean {
            mScaleFactor *= detector!!.scaleFactor
            mScaleFactor = max(0.1f, min(mScaleFactor, 10.0f))
            relativeLayout.scaleX = mScaleFactor
            relativeLayout.scaleY = mScaleFactor
            return true
        }
    }
}