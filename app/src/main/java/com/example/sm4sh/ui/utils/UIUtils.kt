package com.example.sm4sh.ui.utils

import android.content.Context
import kotlin.math.max

class UIUtils {

    companion object{

        fun getScreenSizeMaxDimension(context: Context): Float {

            val r = context.resources
            val w = r.displayMetrics.widthPixels
            val h = r.displayMetrics.heightPixels

            return max(w, h).toFloat()
        }
    }

}