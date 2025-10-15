package com.android.spinners

import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FruitOrderActivity : AppCompatActivity() {

    lateinit var orders : TextView
    lateinit var mango : CheckBox
    lateinit var apple : CheckBox
    lateinit var grapes : CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fruit_order)

    orders = findViewById(R.id.orders)
    mango = findViewById(R.id.mango)
    apple = findViewById(R.id.apple)
    grapes = findViewById(R.id.grapes)

    orders.text = "No Orders Placed"

    mango.setOnClickListener {
        if(mango.isChecked){
            orders.text = "Mangoes in the cart"
            apple.isChecked = false
            grapes.isChecked = false
        }
        else{
            orders.text = "No Orders Placed"
        }
    }
       apple.setOnClickListener {
        if(apple.isChecked){
            orders.text = "Apples in the cart"
            mango.isChecked = false
            grapes.isChecked = false
        }
        else{
            orders.text = "No Orders Placed"
        }
    }
        grapes.setOnClickListener {
        if(grapes.isChecked){
            orders.text = "Grapes in the cart"
            apple.isChecked = false
            mango.isChecked = false
        }
        else{
            orders.text = "No Orders Placed"
        }
    }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ordermain)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}