package com.android.dualproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.dualproject.model.User
import com.android.dualproject.repository.UserRespository

class PortfolioViewModel : ViewModel() {
    private val repository = UserRespository()
    private val _user = MutableLiveData<User>()
    val user : LiveData<User> get() = _user

    init {
        loadUser()
    }
    private fun loadUser(){
        val userData = repository.getUserData()
        _user.value = userData
    }
}