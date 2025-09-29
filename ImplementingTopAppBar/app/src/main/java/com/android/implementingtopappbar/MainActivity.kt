package com.android.implementingtopappbar

import android.os.Bundle
import android.widget.Toast
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    lateinit var toolbar : MaterialToolbar



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(SystemBarStyle.dark(1))
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom)
            insets
        }

     toolbar = findViewById(R.id.toolbar)
     toolbar.overflowIcon = AppCompatResources.getDrawable(this,R.drawable.more)

     toolbar.setNavigationOnClickListener {
         Toast.makeText(applicationContext,"Navigation is clicked",Toast.LENGTH_SHORT).show()
     }
        toolbar.setOnMenuItemClickListener {
            item ->
            val message = when(item.itemId){
                R.id.share -> "Share icon is clicked"
                R.id.share -> "Edit icon is clicked"
                R.id.share -> "Settings icon is clicked"
                else -> "Signout is clicked"
            }

            Toast.makeText(applicationContext,message, Toast.LENGTH_SHORT).show()
            return@setOnMenuItemClickListener true
        }
        
    }
}