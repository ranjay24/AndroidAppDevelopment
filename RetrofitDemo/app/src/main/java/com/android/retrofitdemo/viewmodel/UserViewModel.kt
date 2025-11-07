package com.android.retrofitdemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.retrofitdemo.model.User
import com.android.retrofitdemo.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    private val repository = UserRepository()
    val users = MutableLiveData<List<User>>()
    val errorMessage = MutableLiveData<String>()

    fun fetchUsers() {
        viewModelScope.launch {
            val response = repository.getUsers()
            if (response.isSuccessful) {
                users.postValue(response.body())
            } else {
                errorMessage.postValue("API Error ${response.code()}: ${response.message()}")
            }
        }
    }
}
