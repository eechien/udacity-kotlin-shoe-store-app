package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.User

class UserViewModel: ViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User>
        get() = _user

    private val _signInComplete = MutableLiveData<Boolean>()
    val signInComplete: LiveData<Boolean>
        get() = _signInComplete

    fun signIn(email: String, password: String) {
        if (email == "" || password == "") {
            _signInComplete.value = false
        } else {
            var newUser = User(email, password)
            _user.value = newUser

            _signInComplete.value = true
        }
    }

    fun completeSignIn() {
        _signInComplete.value = null
    }

    fun signOut() {
        _user.value = null
    }
}