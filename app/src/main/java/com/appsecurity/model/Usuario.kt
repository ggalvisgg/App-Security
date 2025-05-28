package com.appsecurity.model

data class Usuario(
    val id: String = "",
    val nombreCompleto: String= "",
    val ciudad : String = "",
    val direccion: String = "",
    val email: String= "",
    val password : String= "",
    val tipo: TipoUsuario = TipoUsuario.CLIENTE
) {


}