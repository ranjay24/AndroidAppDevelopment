package com.android.retrofitexample1

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object{
        val mainURL = "https://jsonplaceholder.typicode.com"
        fun getRetrofitInstance() : Retrofit{
            return Retrofit.Builder().baseUrl(mainURL).addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}