package com.android.profileappbinding.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.profileappbinding.model.User
import com.android.profileappbinding.repository.UserRepository

class UserViewModel : ViewModel() {
    private val repository = UserRepository()
    private val _user = MutableLiveData<User>()
    val user : LiveData<User> = _user

    fun loadUserData(){
        val userData = repository.getUserData()
        _user.value = userData
    }
}