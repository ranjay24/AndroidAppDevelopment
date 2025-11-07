package com.android.retrofitdemo.repository

import com.android.retrofitdemo.network.RetrofitInstance

class UserRepository {
    suspend fun getUsers() = RetrofitInstance.api.getUsers()
}