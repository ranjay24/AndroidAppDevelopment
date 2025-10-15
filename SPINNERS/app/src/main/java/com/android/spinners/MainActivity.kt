package com.android.spinners

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var spinner : Spinner


    //checkbox with intent
    lateinit var openFruitOrder : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

    spinner = findViewById(R.id.spinner)
    val list = listOf("Apple","Orange","Banana","Grapes","Dragon_Fruit")
    val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    spinner.adapter = adapter

    spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
        override fun onItemSelected(
            parent: AdapterView<*>?,
            view: View?,
            position: Int,
            id: Long
        ) {
            val selectedItem = parent?.getItemAtPosition(position).toString()
            Toast.makeText(this@MainActivity,"$selectedItem is selected", Toast.LENGTH_SHORT).show()
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
            TODO("Not yet implemented")
        }

    }


        //checkbox with intent
        openFruitOrder = findViewById(R.id.openNew)
        openFruitOrder.setOnClickListener { view ->
            var intent = Intent(this@MainActivity , FruitOrderActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}