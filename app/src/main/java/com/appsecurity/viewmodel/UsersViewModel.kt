package com.appsecurity.viewmodel

import androidx.lifecycle.ViewModel
import com.appsecurity.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class UsersViewModel : ViewModel() {

    private val _users = MutableStateFlow(emptyList<User>())
    val users : StateFlow< List<User> > =_users.asStateFlow()

    //se agrega el crud
    fun create(user: User){
        _users.value += user
    }

    fun delete(userID: String){
        _users.value -= _users.value.filter { it.id != userID }
    }
}