package com.android.profileappbinding.repository

import com.android.profileappbinding.model.User

class UserRepository {
    fun getUserData() : User{
        return User(
            name = "Ranjay Singh",
            email = "ranjay@define",
            bio = "Android Developer"
        )
    }
}