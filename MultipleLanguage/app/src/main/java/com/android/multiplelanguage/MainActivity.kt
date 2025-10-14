package com.android.multiplelanguage

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    lateinit var show : Button



    //Radio Button Learning Implmentation
    lateinit var display : TextView
    lateinit var learning : CheckBox
    lateinit var learned : CheckBox



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        show = findViewById(R.id.button)

        show.setOnClickListener {
            Toast.makeText(applicationContext,R.string.toast, Toast.LENGTH_LONG).show()
        }




        //Radio Button Learning Implmentation
        display = findViewById(R.id.display)
        learning = findViewById(R.id.learningChecked)
        learned = findViewById(R.id.learnedChecked)

        learning.setOnClickListener {
            if(learning.isChecked){
                display.text = "Still Learning"
                learned.isChecked = false
            }
            else{
                display.text = "What is the Progress ?"
            }


        }
        learned.setOnClickListener {
            if (learned.isChecked){
                display.text = "Learned"
                learning.isChecked  = false
            } else{
                display.text = "What is the Progress ?"
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}