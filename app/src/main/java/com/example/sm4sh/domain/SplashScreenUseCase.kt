package com.example.sm4sh.domain

import android.os.Handler
import android.view.WindowManager
import com.example.sm4sh.R
import com.example.sm4sh.ui.MainActivity


class SplashScreenUseCase {


    private val splashTime = 2500L

    fun hideStatusBarDuringSplashScreen(mainActivity: MainActivity){
        mainActivity.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    fun showStatusBarAfterSplashScreen(mainActivity: MainActivity){
        mainActivity.window.setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)
    }

    fun showSplashScreen(mainActivity: MainActivity) {

        hideStatusBarDuringSplashScreen(mainActivity)

        mainActivity.setContentView(R.layout.splash_screen)

        val handler = Handler()
        val runnable = Runnable {
            closeSplashSreen(mainActivity)
        }

        handler.postDelayed(runnable, splashTime)

    }

    private fun closeSplashSreen(mainActivity: MainActivity) {
        // Set the original activity layout
        showStatusBarAfterSplashScreen(mainActivity)
        mainActivity.setContentView(R.layout.activity_main)
    }
}