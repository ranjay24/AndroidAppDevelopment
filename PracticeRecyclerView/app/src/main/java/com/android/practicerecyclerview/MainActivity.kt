package com.android.practicerecyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewVar: RecyclerView
    private lateinit var myListOfNews: ArrayList<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recyclerViewVar = findViewById(R.id.recyclerView)

        // ✅ Initialize the list before using it
        myListOfNews = ArrayList()

        // ✅ Add data to the list (correct order: heading, description, image)
        myListOfNews.add(
            News(
                newHeading = "This is the Heading of the News",
                newsDescription = "This is the Description of the News",
                newImage = R.drawable.image
            )
        )
        myListOfNews.add(
            News(
                newHeading = "This is the Heading of the News",
                newsDescription = "This is the Description of the News",
                newImage = R.drawable.image
            )
        )
        myListOfNews.add(
            News(
                newHeading = "This is the Heading of the News",
                newsDescription = "This is the Description of the News",
                newImage = R.drawable.image
            )
        )
        myListOfNews.add(
            News(
                newHeading = "This is the Heading of the News",
                newsDescription = "This is the Description of the News",
                newImage = R.drawable.image
            )
        )
        myListOfNews.add(
            News(
                newHeading = "This is the Heading of the News",
                newsDescription = "This is the Description of the News",
                newImage = R.drawable.image
            )
        )
        myListOfNews.add(
            News(
                newHeading = "This is the Heading of the News",
                newsDescription = "This is the Description of the News",
                newImage = R.drawable.image
            )
        )
        myListOfNews.add(
            News(
                newHeading = "This is the Heading of the News",
                newsDescription = "This is the Description of the News",
                newImage = R.drawable.image
            )
        )
        myListOfNews.add(
            News(
                newHeading = "This is the Heading of the News",
                newsDescription = "This is the Description of the News",
                newImage = R.drawable.image
            )
        )
        myListOfNews.add(
            News(
                newHeading = "This is the Heading of the News",
                newsDescription = "This is the Description of the News",
                newImage = R.drawable.image
            )
        )
        myListOfNews.add(
            News(
                newHeading = "This is the Heading of the News",
                newsDescription = "This is the Description of the News",
                newImage = R.drawable.image
            )
        )
        myListOfNews.add(
            News(
                newHeading = "This is the Heading of the News",
                newsDescription = "This is the Description of the News",
                newImage = R.drawable.image
            )
        )
        myListOfNews.add(
            News(
                newHeading = "This is the Heading of the News",
                newsDescription = "This is the Description of the News",
                newImage = R.drawable.image
            )
        )



        // ✅ Handle window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // ✅ Setup RecyclerView
        recyclerViewVar.layoutManager = LinearLayoutManager(this)
        recyclerViewVar.setHasFixedSize(true)

        // ✅ Set adapter
        val adapter = NewsAdapter(this, myListOfNews)
        recyclerViewVar.adapter = adapter
    }
}
