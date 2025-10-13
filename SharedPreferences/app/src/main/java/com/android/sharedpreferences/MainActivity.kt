package com.android.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var userName : EditText
    lateinit var userMessage : EditText
    lateinit var counter : Button
    lateinit var remember : CheckBox

    var count : Int = 0

    var name : String? = null
    var message : String? = null
    var isChecked : Boolean? = null
    lateinit var sharedPreferences : SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        userName = findViewById(R.id.editTextName)
        userMessage = findViewById(R.id.editTextMessage)
        counter = findViewById(R.id.button)
        remember = findViewById(R.id.checkBox)

       counter.setOnClickListener {
           count++
           counter.setText(""+count)
       }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onPause() {
        super.onPause()
        saveDate()
    }

    fun saveDate(){
        sharedPreferences = this.getSharedPreferences("saveData", Context.MODE_PRIVATE)
        name = userName.text.toString()
        message = userMessage.text.toString()
        isChecked = remember.isChecked

        val editor = sharedPreferences.edit()

        editor.putString("key name" , name)
        editor.putString("Key message", message)
        editor.putInt("key count",count)
        editor.putBoolean("key boolean",isChecked!!)

        editor.apply()
        Toast.makeText(applicationContext,"App Data Saved" , Toast.LENGTH_SHORT).show()
    }

    fun retreiveData(){
        sharedPreferences = this.getSharedPreferences("saveData", Context.MODE_PRIVATE)
        name = sharedPreferences.getString("key name",null)
        message = sharedPreferences.getString("key message",null)
        count = sharedPreferences.getInt("key count",0)
        isChecked = sharedPreferences.getBoolean("key boolean",false)

        userName.setText(name)
        userMessage.setText(message)
        counter.setText(""+count)
        remember.isChecked = isChecked!!
    }

    override fun onResume() {
        super.onResume()
        retreiveData()
    }


}