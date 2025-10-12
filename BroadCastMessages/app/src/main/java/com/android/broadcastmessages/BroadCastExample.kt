package com.android.broadcastmessages

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BroadCastExample: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val isAirplaneMode : Boolean = intent!!.getBooleanExtra("state" , false)

        if (isAirplaneMode) {
            Toast.makeText(context, "This Device is in airplane mode", Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(context, "This Device is not in airplane mode", Toast.LENGTH_LONG).show()
        }
    }
}