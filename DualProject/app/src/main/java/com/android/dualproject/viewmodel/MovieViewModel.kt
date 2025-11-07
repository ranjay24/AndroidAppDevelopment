package com.android.dualproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.dualproject.model.Movie
import com.android.dualproject.repository.MovieRepository

class MovieViewModel : ViewModel() {
    private val repository = MovieRepository()
    private val _movies = MutableLiveData<List<Movie>>()

    val movies : LiveData<List<Movie>> = _movies

    fun loadMovies(){
        _movies.value = repository.getMovies()
    }
}