package com.appsecurity.model

data class VerificacionReporte(
    val id: String,
    val reporteId: String,
    val verificadoPor: Usuario,
    val estado: EstadoVerificacion,
    val motivoRechazo: String? = null,
    val fechaVerificacion: String
)
