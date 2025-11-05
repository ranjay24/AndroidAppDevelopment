package com.android.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    val toastMessage = MutableLiveData<String>()

    fun onLoginClicked() {
        val emailInput = email.value
        val passwordInput = password.value

        when {
            emailInput.isNullOrEmpty() || passwordInput.isNullOrEmpty() -> {
                toastMessage.value = "Email or Password cannot be empty"
            }
            emailInput == "ranjay@gmail.com" && passwordInput == "Ranjay@123" -> {
                toastMessage.value = "Login successful"
            }
            else -> {
                toastMessage.value = "Invalid credentials "
            }
        }
    }

    fun onForgotPasswordClicked() {
        toastMessage.value = "Forgot Password clicked"
    }

    fun onSignUpClicked() {
        toastMessage.value = "Sign Up clicked "
    }
}