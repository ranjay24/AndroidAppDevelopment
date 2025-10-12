package com.android.services

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.JobIntentService

class JobIntentServiceExample : JobIntentService() {
    override fun onHandleWork(intent: Intent) {
        Log.d("Service","Job Intent Service Started")
        Log.d("Service Threads" , Thread.currentThread().name)
    }

    companion object{
        fun myBackgroundService(context: Context , intent : Intent){
            enqueueWork(context, JobIntentServiceExample::class.java,1,intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Service " , "Service is Destroyed")
    }
}