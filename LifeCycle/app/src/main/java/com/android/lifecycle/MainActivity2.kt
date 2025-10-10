package com.android.lifecycle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {


    lateinit var goBack : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)


        goBack = findViewById(R.id.button3)
        goBack.setOnClickListener {
            var intent = Intent(this@MainActivity2 , MainActivity::class.java)
            startActivity(intent)
        }
        Log.d("Message","Second Activity onCreate")

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("Message","Second Activity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Message","Second Activity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Message","Second Activity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Message","Second Activity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Message","Second Activity onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Message","Second Activity onRestart")
    }
}