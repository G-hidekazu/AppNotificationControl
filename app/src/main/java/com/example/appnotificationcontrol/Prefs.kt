package com.example.appnotificationcontrol

import android.content.Context

object Prefs {
    private const val PREFS_NAME = "notification_control"
    private const val KEY_BETWEEN_MUTED = "between_muted"

    fun isBetweenMuted(context: Context): Boolean {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .getBoolean(KEY_BETWEEN_MUTED, false)
    }

    fun toggleBetweenMuted(context: Context): Boolean {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val newValue = !prefs.getBoolean(KEY_BETWEEN_MUTED, false)
        prefs.edit().putBoolean(KEY_BETWEEN_MUTED, newValue).apply()
        return newValue
    }
}
