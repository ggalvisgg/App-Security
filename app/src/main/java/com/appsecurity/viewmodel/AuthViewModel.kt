package com.appsecurity.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsecurity.model.Usuario
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    var registroExitoso by mutableStateOf<Boolean?>(null)
        private set

    var errorRegistro by mutableStateOf<String?>(null)
        private set

    var loginExitoso by mutableStateOf<Boolean?>(null)
        private set

    var tipoUsuario by mutableStateOf<String?>(null) // "CLIENTE" o "MODERADOR"

    var errorLogin by mutableStateOf<String?>(null)
        private set

    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()

    fun registrarUsuario(usuario: Usuario, password: String) {
        viewModelScope.launch {
            auth.createUserWithEmailAndPassword(usuario.email, password)
                .addOnSuccessListener { result ->
                    val uid = result.user?.uid ?: ""
                    val nuevoUsuario = usuario.copy(id = uid)

                    db.collection("usuarios").document(uid).set(nuevoUsuario)
                        .addOnSuccessListener {
                            registroExitoso = true
                        }
                        .addOnFailureListener { e ->
                            errorRegistro = "Error al guardar en Firestore: ${e.message}"
                        }

                }
                .addOnFailureListener { e ->
                    errorRegistro = "Error en registro: ${e.message}"
                }
        }
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            auth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener { result ->
                    val uid = result.user?.uid ?: ""
                    db.collection("usuarios").document(uid).get()
                        .addOnSuccessListener { document ->
                            if (document.exists()) {
                                tipoUsuario = document.getString("tipo") ?: "CLIENTE"
                                loginExitoso = true
                            } else {
                                errorLogin = "Usuario no registrado en Firestore."
                            }
                        }
                        .addOnFailureListener {
                            errorLogin = "Error al obtener datos del usuario."
                        }
                }
                .addOnFailureListener { e ->
                    errorLogin = "Login fallido: ${e.message}"
                }
        }
    }

    fun recuperarContrasenia(
        email: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        Firebase.auth.sendPasswordResetEmail(email)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { e ->
                onError(e.message ?: "Error al enviar correo de recuperación")
            }
    }


    fun limpiarEstado() {
        registroExitoso = null
        errorRegistro = null
        loginExitoso = null
        errorLogin = null
        tipoUsuario = null
    }
}
