package com.android.retrofitdemo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.retrofitdemo.databinding.ActivityMainBinding
import com.android.retrofitdemo.view.UserAdapter
import com.android.retrofitdemo.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val viewModel : UserViewModel by viewModels ()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)

      binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
      binding.viewModel =viewModel
      binding.lifecycleOwner = this

      binding.recyclerView.layoutManager = LinearLayoutManager(this)
      binding.btnLoad.setOnClickListener {
          viewModel.fetchUsers()
      }
      viewModel.users.observe(this, Observer{
          binding.recyclerView.adapter = UserAdapter(it)
      })

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}