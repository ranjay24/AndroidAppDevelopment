package com.android.dualproject.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.viewbinding.ViewBinding
import com.android.dualproject.R
import com.android.dualproject.databinding.ActivityPortfolioBinding
import com.android.dualproject.viewmodel.PortfolioViewModel

class PortfolioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPortfolioBinding
    private val viewModel : PortfolioViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_portfolio)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_portfolio)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this



    }
}