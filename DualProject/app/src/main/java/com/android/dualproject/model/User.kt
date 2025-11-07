package com.android.dualproject.model

data class User(
    val name: String,
    val bio : String,
    val skills : List<String>,
    val profileImage : Int
)
