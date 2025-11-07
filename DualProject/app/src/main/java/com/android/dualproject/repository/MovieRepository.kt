package com.android.dualproject.repository

import com.android.dualproject.model.Movie
import com.android.dualproject.R
class MovieRepository {

    fun getMovies() : List<Movie>{
        return listOf(
            Movie("KING", 2010, 8.8, R.drawable.king),
            Movie("SINGHAM", 2014, 8.6, R.drawable.singham),
            Movie("SON OF SARDAR", 2008, 9.0, R.drawable.sonofsardar),
            Movie("RAMAYAN", 2009, 7.8, R.drawable.ramayan)
        )
    }
}