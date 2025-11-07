package com.android.profileappbinding.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.android.profileappbinding.R
import com.android.profileappbinding.databinding.ActivityMainBinding
import com.android.profileappbinding.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1️⃣ Bind XML layout to Activity
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // 2️⃣ Connect ViewModel to layout
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
    }
}