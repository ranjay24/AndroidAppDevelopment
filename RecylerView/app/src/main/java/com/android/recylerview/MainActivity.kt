package com.android.recylerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var recylerView : RecyclerView
    var nameList = ArrayList<String>()
    var detailList = ArrayList<String>()
    var imageList = ArrayList<Int>()

    lateinit var  adapter: ContactAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recylerView = findViewById(R.id.recyclerView)
//        recylerView.layoutManager = GridLayoutManager(this,2)
        recylerView.layoutManager = LinearLayoutManager(this@MainActivity)

        nameList.add("Digvijay")
        nameList.add("Ranjay")
        nameList.add("Sujeet")

        detailList.add("8149633683")
        detailList.add("7414968926")
        detailList.add("9021969026")

        imageList.add(R.drawable.digvijay)
        imageList.add(R.drawable.ranjay)
        imageList.add(R.drawable.sujeet)


        adapter = ContactAdapter(nameList,detailList,imageList,this@MainActivity)
        recylerView.adapter = adapter


    }
}