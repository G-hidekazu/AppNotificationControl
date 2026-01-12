package com.example.appnotificationcontrol

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification

class BetweenNotificationListener : NotificationListenerService() {
    override fun onListenerConnected() {
        super.onListenerConnected()
        if (Prefs.isBetweenMuted(this)) {
            activeNotifications?.forEach { sbn ->
                if (sbn.packageName == BETWEEN_PACKAGE) {
                    cancelNotification(sbn.key)
                }
            }
        }
    }

    override fun onNotificationPosted(sbn: StatusBarNotification) {
        if (!Prefs.isBetweenMuted(this)) {
            return
        }
        if (sbn.packageName == BETWEEN_PACKAGE) {
            cancelNotification(sbn.key)
        }
    }

    companion object {
        private const val BETWEEN_PACKAGE = "kr.co.vcnc.between"
    }
}
