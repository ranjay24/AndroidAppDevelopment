package com.android.lifecycle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var plusOne : Button
    lateinit var changeActy : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        textView = findViewById(R.id.textView)
        plusOne = findViewById(R.id.plusOne)
        changeActy = findViewById(R.id.changeActy)

        var count  = 0

        plusOne.setOnClickListener {
            count = count+1
            textView.text = ""+count
        }

        changeActy.setOnClickListener { view ->
            var intent = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(intent)

        }

        Log.d("Message","First Activity onCreate")

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("Message","First Activity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Message","First Activity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Message","First Activity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Message","First Activity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Message","First Activity onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Message","First Activity onRestart")
    }


}