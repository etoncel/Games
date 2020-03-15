package com.example.sm4sh.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.sm4sh.domain.SplashScreenUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var splashScreenUseCase: SplashScreenUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashScreenUseCase = SplashScreenUseCase()
        splashScreenUseCase.showSplashScreen(this)
    }
}
