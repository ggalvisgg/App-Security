package com.appsecurity.model

data class Reporte(
    val id: String = "",
    val titulo: String = "",
    val descripcion: String = "",
    val categoria: String = "",
    val latitud: Double = 0.0,
    val longitud: Double = 0.0,
    val urlImagen: String = "",
    val uidUsuario: String = "",
    val estado: String = "PENDIENTE",
    val importante: Int = 0,
    val fechaCreacion: Long = System.currentTimeMillis()
)

