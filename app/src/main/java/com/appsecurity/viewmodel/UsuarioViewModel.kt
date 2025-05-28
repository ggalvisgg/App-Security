package com.appsecurity.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import com.appsecurity.model.Usuario
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class UsuarioViewModel : ViewModel() {

    var usuario by mutableStateOf<Usuario?>(null)
        private set

    var actualizacionExitosa by mutableStateOf(false)
    var errorActualizacion by mutableStateOf<String?>(null)

    var eliminacionExitosa by mutableStateOf(false)
    var errorEliminacion by mutableStateOf<String?>(null)

    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()

    init {
        obtenerDatosUsuario()
    }

    fun obtenerDatosUsuario() {
        val uid = auth.currentUser?.uid ?: return
        db.collection("usuarios").document(uid).get()
            .addOnSuccessListener { doc ->
                usuario = doc.toObject(Usuario::class.java)
            }
    }

    fun actualizarUsuario(nombre: String, ciudad: String, direccion: String, email: String, password: String) {
        val uid = auth.currentUser?.uid ?: return

        val actualizacion = mapOf(
            "nombreCompleto" to nombre,
            "ciudad" to ciudad,
            "direccion" to direccion,
            "email" to email,
            "password" to password
        )

        db.collection("usuarios").document(uid)
            .update(actualizacion)
            .addOnSuccessListener {
                actualizacionExitosa = true
            }
            .addOnFailureListener {
                errorActualizacion = "Error al actualizar: ${it.message}"
            }
    }

    fun eliminarCuenta() {
        val user = FirebaseAuth.getInstance().currentUser ?: return
        val uid = user.uid
        val db = FirebaseFirestore.getInstance()

        // Eliminar primero en Firestore
        db.collection("usuarios").document(uid).delete()
            .addOnSuccessListener {
                // Luego eliminar en Authentication
                user.delete()
                    .addOnSuccessListener {
                        eliminacionExitosa = true
                    }
                    .addOnFailureListener {
                        errorEliminacion = "Error eliminando usuario en Auth: ${it.message}"
                    }
            }
            .addOnFailureListener {
                errorEliminacion = "Error eliminando en Firestore: ${it.message}"
            }
    }

    fun limpiarEstados() {
        actualizacionExitosa = false
        errorActualizacion = null
    }

    fun limpiarEstadoEliminacion() {
        eliminacionExitosa = false
        errorEliminacion = null
    }
}
