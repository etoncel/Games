package com.example.sm4sh.domain

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sm4sh.R

class WalkThroughUseCase {


    fun goToNextSlide(fragment:Fragment){
        fragment.findNavController().navigate(R.id.next_action)
    }

    fun goToGames(fragment: Fragment){
        fragment.findNavController().navigate(R.id.next_action)
    }
}