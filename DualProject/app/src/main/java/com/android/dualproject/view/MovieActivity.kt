package com.android.dualproject.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.dualproject.databinding.ActivityMovieBinding
import com.android.dualproject.viewmodel.MovieViewModel
import com.android.dualproject.model.Movie

class MovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieBinding


    private val movieViewModel: MovieViewModel by viewModels()

    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MovieAdapter(emptyList())
        binding.recyclerMovies.layoutManager = LinearLayoutManager(this)
        binding.recyclerMovies.adapter = adapter

        movieViewModel.movies.observe(this) { movies ->
            adapter.updateData(movies)
        }

        movieViewModel.loadMovies()
    }
}
