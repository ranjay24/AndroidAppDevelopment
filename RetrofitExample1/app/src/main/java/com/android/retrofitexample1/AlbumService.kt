package com.android.retrofitexample1

import retrofit2.http.GET

interface AlbumService {
    @GET("/albums")
    suspend fun getAlbums(): retrofit2.Response<Albums>
}