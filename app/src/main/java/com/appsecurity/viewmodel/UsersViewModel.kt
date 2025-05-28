package com.appsecurity.viewmodel

import androidx.lifecycle.ViewModel
import com.appsecurity.model.Usuario
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class UsersViewModel : ViewModel() {

    private val _users = MutableStateFlow(emptyList<Usuario>())
    val users : StateFlow< List<Usuario> > =_users.asStateFlow()

    fun create(user: Usuario){
        _users.value += user
    }

    fun delete(userID: String){
        _users.value -= _users.value.filter { it.id != userID }
    }
}