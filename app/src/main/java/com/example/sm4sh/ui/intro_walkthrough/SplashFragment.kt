package com.example.sm4sh.ui.intro_walkthrough


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sm4sh.R
import com.example.sm4sh.domain.SplashScreenUseCase


class SplashFragment : Fragment() {

    private lateinit var splashScreenUseCase: SplashScreenUseCase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        splashScreenUseCase = SplashScreenUseCase()
        splashScreenUseCase.showSplashScreen(this)
    }


}
