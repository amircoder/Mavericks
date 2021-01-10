package com.multithread.dindinntest.extension


import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import dagger.android.DaggerActivity

fun DaggerActivity.makeFullScreen(){
    requestWindowFeature(Window.FEATURE_NO_TITLE)
    this.window.setFlags(
        WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN
    )
    actionBar?.apply {
        hide()
    }
}

fun AppCompatActivity.makeFullScreen(){
    requestWindowFeature(Window.FEATURE_NO_TITLE)
    this.window.setFlags(
        WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN
    )
    supportActionBar?.apply {
        hide()
    }
}