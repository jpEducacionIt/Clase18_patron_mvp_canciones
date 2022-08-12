package com.example.clase18_patron_mvp_canciones

import android.app.Activity

object Utils {
    fun isActivityAlive(activity: Activity) : Boolean {
        return !activity.isFinishing && !activity.isDestroyed
    }
}