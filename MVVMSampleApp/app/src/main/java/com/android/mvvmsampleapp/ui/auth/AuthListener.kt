package com.android.mvvmsampleapp.ui.auth

interface AuthListner {

    fun onStarted()
    fun onSuccess()
    fun onFailure(message : String)
}