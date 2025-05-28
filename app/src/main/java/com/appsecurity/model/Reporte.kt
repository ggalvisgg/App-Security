package com.appsecurity.model

data class Reporte(
    val id: String,
    val titulo: String,
    val descripcion: String,
    val categoria: CategoriaReporte,
    val ubicacion: Coordenadas,
    val imagenes: List<Imagen>,
    val estado: EstadoReporte,
    val importancia: Int,
    val creadoPor: Usuario,
    val motivoRechazo: String? = null,
    val fechaCreacion: String,
    val fechaModificacion: String
)
