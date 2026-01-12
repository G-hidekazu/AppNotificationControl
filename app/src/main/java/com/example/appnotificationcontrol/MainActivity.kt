package com.example.appnotificationcontrol

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val statusText = findViewById<TextView>(R.id.statusText)
        if (!hasNotificationAccess()) {
            statusText.setText(R.string.status_needs_access)
            startActivity(Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS))
            return
        }

        val newState = Prefs.toggleBetweenMuted(this)
        val toastMessage = if (newState) {
            R.string.toggle_off
        } else {
            R.string.toggle_on
        }
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
        updateStatus(statusText)
    }

    override fun onResume() {
        super.onResume()
        val statusText = findViewById<TextView>(R.id.statusText)
        updateStatus(statusText)
    }

    private fun updateStatus(statusText: TextView) {
        if (!hasNotificationAccess()) {
            statusText.setText(R.string.status_needs_access)
            return
        }
        val muted = Prefs.isBetweenMuted(this)
        statusText.setText(if (muted) R.string.status_off else R.string.status_on)
    }

    private fun hasNotificationAccess(): Boolean {
        val enabledPackages = NotificationManagerCompat.getEnabledListenerPackages(this)
        return enabledPackages.contains(packageName)
    }
}
