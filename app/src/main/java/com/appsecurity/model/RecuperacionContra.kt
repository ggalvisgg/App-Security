package com.appsecurity.model

data class RecuperacionContra(
    val id: String,
    val usuarioEmail: String,
    val token: String,
    val fechaSolicitud: String,
    val expiracion: String
)
