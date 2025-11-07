package com.android.dualproject.repository

import com.android.dualproject.model.User
import com.android.dualproject.R

class UserRespository {

    fun getUserData(): User{
        return User(
            name = "Ranjay Singh",
            bio = "Android Developer in training. Passionate about building beautiful apps with MVVM.",
            skills = listOf("Kotlin","Android Studio","XML","MVM Architecture"),
            profileImage = R.drawable.profile1
        )
    }
}