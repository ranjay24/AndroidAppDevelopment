package com.android.androidcourseretrofitrecycler

import com.android.androidcourseretrofitrecycler.Posts
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitAPI {

    @GET("/posts")
    fun getAllPosts() : Call<List<Posts>>
}