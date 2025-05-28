package com.appsecurity.model

data class Direccion(
    val ciudad: String = "",
    val calle: String= "",
    val ubicacion : Coordenadas
)
