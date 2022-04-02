package com.digitalamanmedia.bhumistar

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import android.widget.Toast
import com.digitalamanmedia.bhumistar.core.Commons.Companion.CHANNEL_ID_1
import com.digitalamanmedia.bhumistar.core.Commons.Companion.CHANNEL_ID_2
import com.digitalamanmedia.bhumistar.core.Commons.Companion.CHANNEL_ID_3
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.HiltAndroidApp
import com.digitalamanmedia.bhumistar.persentation.MainActivity

import android.R

import androidx.annotation.NonNull

import com.google.android.gms.tasks.OnCompleteListener

import com.google.firebase.messaging.FirebaseMessaging




@HiltAndroidApp
class BhumistarApp: Application(){
    override fun onCreate() {
        super.onCreate()

        createNotificationChannel()
        FirebaseMessaging.getInstance().subscribeToTopic("bhumistar")
            .addOnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.d("tag","success")
                }

            }
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {


            val channel1 = NotificationChannel(CHANNEL_ID_1, "Channel1", NotificationManager.IMPORTANCE_DEFAULT).apply {
                description = "This is channel 1"

            }
            val channel2 = NotificationChannel(CHANNEL_ID_2, "Channel2", NotificationManager.IMPORTANCE_HIGH).apply {
                description = "This is channel 2"
                enableVibration(true)
                setSound(null,null)
                vibrationPattern = longArrayOf(0,2000,2000,2000,2000,2000,2000,2000)
            }
            val channel3 = NotificationChannel(CHANNEL_ID_3, "Channel3", NotificationManager.IMPORTANCE_HIGH).apply {
                description = "This is channel 2"
                enableVibration(true)
                vibrationPattern = longArrayOf(0,2000,2000,2000,2000,2000,2000,2000)
            }

            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel1)
            notificationManager.createNotificationChannel(channel2)
            notificationManager.createNotificationChannel(channel3)
        }
    }
}