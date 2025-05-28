package com.appsecurity.model

data class Comentario(
    val id: String,
    val contenido: String,
    val autor: Usuario,
    val fecha: String,
    val reporteId: String
)
