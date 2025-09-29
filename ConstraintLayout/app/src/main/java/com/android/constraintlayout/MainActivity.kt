package com.android.constraintlayout

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

//you can use late init to acknowledge the editor that the value is lately going to be initialize
//    For TextView and Button tuturial
//    var myText : TextView? = null
//lateinit var myText : TextView
//lateinit var myButton: Button
//lateinit var doMagic: Button
@SuppressLint("MissingInflatedId")
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContentView(R.layout.activity_main)

//for user input
    lateinit var name : EditText
    lateinit var Ok : Button
    lateinit var result : TextView
    lateinit var image : ImageView
    name = findViewById(R.id.editTextName)
    Ok = findViewById(R.id.buttonOk)
    result = findViewById(R.id.textViewResult)
    image = findViewById(R.id.imageExample)

    Ok.setOnClickListener {
       var userName : String =  name.text.toString()
        result.setText(userName)
        image.setImageResource(R.drawable.img)

    }







//        myText = findViewById(R.id.textExample)
//        myText.setTextColor(Color.RED)
//        myText.setOnClickListener {
//            myText.setTextColor(Color.BLACK)
//            myText.setBackgroundColor(Color.GRAY)
//        }
//   For TextView and Button tuturial
//    myText = findViewById(R.id.textExample)
//    myButton = findViewById(R.id.button1)
//    doMagic = findViewById(R.id.button2)
//
//    doMagic.setOnClickListener {
//        doMagic.setBackgroundColor(Color.BLACK)
//        myText.setText("Magic have been done")
//        myText.isVisible = false
//
//    }
//myButton.setOnClickListener {
//myText.isVisible = true
//doMagic.isVisible = true
//}



    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
        val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
        insets
    }
}
}