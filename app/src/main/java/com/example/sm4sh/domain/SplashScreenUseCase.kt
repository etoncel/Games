package com.example.sm4sh.domain

import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.sm4sh.R

class SplashScreenUseCase {


    private val splashTime = 2500L
    private val walkThroughUseCase = WalkThroughUseCase()

    private fun hideStatusBarDuringSplashScreen(activity: AppCompatActivity){
        activity.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    private fun showStatusBarAfterSplashScreen(activity: AppCompatActivity){
        activity.window.setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)
    }

    fun showSplashScreen(fragment: Fragment) {

        hideStatusBarDuringSplashScreen(fragment.activity as AppCompatActivity)

        val handler = Handler()
        val runnable = Runnable {
            closeSplashSreen(fragment)
        }

        handler.postDelayed(runnable, splashTime)

    }

    private fun closeSplashSreen(fragment: Fragment) {
        val activity = fragment.activity as AppCompatActivity
        showStatusBarAfterSplashScreen(activity)
        activity.setTheme(R.style.AppTheme)
        // Check if user should see the intro
        walkThroughUseCase.goToNextSectionAfterSplashScreen(fragment)
    }

}