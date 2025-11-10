package com.android.moviemaniaa.ui.splash

import android.content.Intent
import com.android.moviemaniaa.R
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.moviemaniaa.databinding.ActivitySplashBinding
import com.android.moviemaniaa.main.MainActivity

class SplashActivity : AppCompatActivity() {

private lateinit var binding : ActivitySplashBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.root.postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        },3000)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}