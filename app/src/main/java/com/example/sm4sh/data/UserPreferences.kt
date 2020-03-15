package com.example.sm4sh.data

import com.example.sm4sh.ui.MainActivity

class UserPreferences {

    private val prefsName = "com.example.sm4sh.prefs"
    private val walkThroughDonPrefKey = "user_walkThrough_done_key"

    fun setIsUserWalkThroughDone(activity: MainActivity){
        val prefs = activity.getSharedPreferences(prefsName, 0)
        val editor = prefs.edit()
        editor.putBoolean(walkThroughDonPrefKey, true)
        editor.apply()
    }


    fun getIsUserWalkThroughDone(activity: MainActivity): Boolean {
        val prefs = activity.getSharedPreferences(prefsName, 0) ?: return false
        return prefs.getBoolean(walkThroughDonPrefKey, false)
    }

}