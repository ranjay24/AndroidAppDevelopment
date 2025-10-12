package com.android.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class ClassicServicesExample : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("Services" , "Classic Service is Created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("Services" , "Classic Service is Started")
        Log.d("Services Threads" , Thread.currentThread().name)

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {

        super.onDestroy()
        Log.d("Services" , "Classic Service is Destroyed")
    }
}