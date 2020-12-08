package com.erdemtsynduev.rotate360degree

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val arrayListPictureAssets: ArrayList<String> = ArrayList()
    var playImage = true
    var isReverse = true
    var indexImage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createListAssetsImage()
        coroutinesStartFunction()

        main_activity_root_layout.setOnTouchListener(object : OnSwipeTouchListener() {
            override fun onSwipeLeft() {
                isReverse = false
            }

            override fun onSwipeRight() {
                isReverse = true
            }
        })

        main_activity_btn_pause.setOnClickListener {
            playImage = !playImage
            if (playImage) {
                main_activity_btn_pause.setImageResource(R.drawable.ic_baseline_pause)
                coroutinesStartFunction()
            } else {
                main_activity_btn_pause.setImageResource(R.drawable.ic_baseline_play_arrow)
            }
        }

        main_activity_btn_right.setOnClickListener {
            if (playImage) {
                isReverse = true
            } else {
                indexImage--
                checkNumberIndex()
                runOnUiThread {
                    Glide.with(this).load(arrayListPictureAssets[indexImage])
                        .placeholder(main_activity_photo_image.drawable)
                        .into(main_activity_photo_image)
                }
            }
        }

        main_activity_btn_left.setOnClickListener {
            if (playImage) {
                isReverse = false
            } else {
                indexImage++
                checkNumberIndex()
                runOnUiThread {
                    Glide.with(this).load(arrayListPictureAssets[indexImage])
                        .placeholder(main_activity_photo_image.drawable)
                        .into(main_activity_photo_image)
                }
            }
        }
    }

    private fun coroutinesStartFunction() {
        GlobalScope.launch {
            playImageLikeGif()

        }
    }

    private suspend fun playImageLikeGif() {
        while (playImage) {
            checkNumberIndex()
            runOnUiThread {
                Glide.with(this).load(arrayListPictureAssets[indexImage])
                    .placeholder(main_activity_photo_image.drawable)
                    .into(main_activity_photo_image)
            }
            delay(100)
            increaseIndex()
        }
    }


    private fun checkNumberIndex() {
        if (indexImage < 0) {
            indexImage = 35
        } else if (indexImage > 35) {
            indexImage = 0
        }
    }

    private fun increaseIndex() {
        if (isReverse) {
            indexImage--
        } else {
            indexImage++
        }
    }

    private fun createListAssetsImage() {
        arrayListPictureAssets.add("file:///android_asset/AVF_2696.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2697.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2698.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2699.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2700.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2701.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2702.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2703.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2704.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2705.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2706.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2707.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2708.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2709.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2710.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2711.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2712.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2713.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2714.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2715.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2716.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2717.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2718.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2719.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2720.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2721.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2722.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2723.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2724.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2725.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2726.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2727.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2728.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2729.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2730.jpg")
        arrayListPictureAssets.add("file:///android_asset/AVF_2731.jpg")
    }
}