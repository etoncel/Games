package com.example.sm4sh.data

import androidx.appcompat.app.AppCompatActivity

class UserPreferences {

    private val prefsName = "com.example.sm4sh.prefs"
    private val walkThroughDonPrefKey = "user_walkThrough_done_key"

    fun setIsUserWalkThroughDone(activity: AppCompatActivity){
        val prefs = activity.getSharedPreferences(prefsName, 0)
        val editor = prefs.edit()
        editor.putBoolean(walkThroughDonPrefKey, true)
        editor.apply()
    }


    fun getIsUserWalkThroughDone(activity: AppCompatActivity): Boolean {
        val prefs = activity.getSharedPreferences(prefsName, 0) ?: return false
        return prefs.getBoolean(walkThroughDonPrefKey, false)
    }

}