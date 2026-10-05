package com.example.par1p3.model

data class Cliente(
    val id: Int,
    val nombre: String,
    val email: String,
    val telefono: String
) {
    override fun toString(): String = "$nombre <$email>"
}