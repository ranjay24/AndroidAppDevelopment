package com.android.dualproject.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.dualproject.R
import com.android.dualproject.databinding.ActivityMainBinding
import com.android.dualproject.view.PortfolioActivity
import com.android.dualproject.view.MovieActivity
import com.android.dualproject.

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPortfolio.setOnClickListener {
            startActivity(Intent(this, PortfolioActivity::class.java))
        }

        binding.btnMovies.setOnClickListener {
            startActivity(Intent(this, MovieActivity::class.java))
        }

        // Safely handle insets using binding.root
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
