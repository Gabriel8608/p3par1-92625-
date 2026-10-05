package com.example.par1p3.model

data class Autor(
    val id: Int,
    val nombre: String,
    val nacionalidad: String
) {
    override fun toString(): String = "$nombre ($nacionalidad)"
}