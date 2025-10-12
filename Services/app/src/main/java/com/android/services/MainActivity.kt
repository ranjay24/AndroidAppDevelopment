package com.android.services

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    lateinit var startClassic : Button
    lateinit var startJob : Button
    lateinit var stop : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        startClassic = findViewById(R.id.startClassicService)
        startJob = findViewById(R.id.startJobIntentService)
        stop = findViewById(R.id.stopService)

        startClassic.setOnClickListener {
        val intent = Intent(this@MainActivity , ClassicServicesExample::class.java)
            startService(intent)
        }


        startJob.setOnClickListener {
            var intent = Intent(this@MainActivity , JobIntentServiceExample::class.java)
            JobIntentServiceExample.myBackgroundService(this@MainActivity , intent)
        }


        stop.setOnClickListener {
            var intent = Intent(this@MainActivity, ClassicServicesExample::class.java)
            stopService(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}