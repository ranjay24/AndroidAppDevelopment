package com.android.gridview

import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    lateinit var gridView : GridView
    var nameList  = ArrayList<String>()
    var imageList = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        gridView = findViewById(R.id.gridView)
        fillArrayls()
        var adapter = PlayerAdapter(this,nameList,imageList)
        gridView.adapter  = adapter
        gridView.setOnItemClickListener{
            adapterView , view, position, id ->
            Toast.makeText(this,"You Clicked ${nameList[position]}", Toast.LENGTH_LONG).show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun fillArrayls(){
        nameList.add("Shikhar Dhawan")
        nameList.add("Rohit Sharma")
        nameList.add("Virat Kohli")
        nameList.add("Suresh Raina")
        nameList.add("M S Dhoni")
        nameList.add("Ravindra Jadeja")
        nameList.add("Ravischandra Ashwin")
        nameList.add("Jasprit Bumrah")
        nameList.add("Hardit Pandya")

        imageList.add(R.drawable.dhawan)
        imageList.add(R.drawable.rohit)
        imageList.add(R.drawable.virat)
        imageList.add(R.drawable.raina)
        imageList.add(R.drawable.dhoni)
        imageList.add(R.drawable.jadeja)
        imageList.add(R.drawable.ashwin)
        imageList.add(R.drawable.jasprit)
        imageList.add(R.drawable.pandya)
    }
}