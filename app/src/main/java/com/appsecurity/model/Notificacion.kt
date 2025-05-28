package com.appsecurity.model

data class Notificacion(
    val id: String,
    val titulo: String,
    val mensaje: String,
    val usuarioDestino: Usuario,
    val tipo: TipoNotificacion,
    val referenciaReporteId: String? = null,
    val fechaEnvio: String,
    val leido: Boolean
)
