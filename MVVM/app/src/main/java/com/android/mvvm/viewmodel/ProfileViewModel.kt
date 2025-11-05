package com.android.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.mvvm.model.User
import com.android.mvvm.model.UserRepository

class ProfileViewModel : ViewModel() {
    private val repository = UserRepository()
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    fun loadUser(){
        val userData= repository.getUser()
        _user.value = userData
    }
}