package com.android.mathgame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var addition : Button
    lateinit var substraction : Button
    lateinit var multiplication : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        addition = findViewById(R.id.buttonAdd)
        substraction = findViewById(R.id.buttonSub)
        multiplication = findViewById(R.id.buttonMul)

        addition.setOnClickListener { view ->
            val intent = Intent(this@MainActivity, GameActivity::class.java)
            intent.putExtra("operationType","add")
            startActivity(intent)
        }
        substraction.setOnClickListener { view ->
            val intent = Intent(this@MainActivity, GameActivity::class.java)
            intent.putExtra("operationType","sub")
            startActivity(intent)
        }
        multiplication.setOnClickListener { view ->
            val intent = Intent(this@MainActivity, GameActivity::class.java)
            intent.putExtra("operationType","mul")
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}