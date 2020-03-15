package com.example.sm4sh.domain

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sm4sh.R
import com.example.sm4sh.data.UserPreferences

class WalkThroughUseCase {

    private val userPreferences = UserPreferences()


    fun goToNextSlide(fragment:Fragment){
        fragment.findNavController().navigate(R.id.next_action)
    }

    fun goToGames(fragment: Fragment){
        fragment.findNavController().navigate(R.id.next_action)
        userPreferences.setIsUserWalkThroughDone(fragment.activity as AppCompatActivity)
    }


    fun goToNextSectionAfterSplashScreen(fragment: Fragment){
        val isWalkThroughDone = userPreferences.getIsUserWalkThroughDone(fragment.activity as AppCompatActivity)
        if (isWalkThroughDone){
            goToGamesFromSplashScreen(fragment)
        }
        else{
            goToWalkThrough(fragment)
        }
    }

    private fun goToWalkThrough(fragment: Fragment){
        fragment.findNavController().navigate(R.id.splash_to_walkThrough_action)
    }

    private fun goToGamesFromSplashScreen(fragment: Fragment){
        fragment.findNavController().navigate(R.id.splash_to_games_action)
    }

}