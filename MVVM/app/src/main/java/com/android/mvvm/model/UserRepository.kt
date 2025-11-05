package com.android.mvvm.model

class UserRepository {
    fun getUser() : User{
        return User(
            name = "Ranjay Singh",
            email = "ranjay@definelabs.com",
            age = 22)
    }
}