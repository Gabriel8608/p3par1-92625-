package com.example.par1p3.model

class Libro(
    val isbn: String,
    val titulo: String,
    val genero: String,
    val precio: Double,
    var stock: Int,
    val autor: Autor
) {
    fun hayStock(): Boolean = stock > 0

    fun reducirStock(cantidad: Int) {
        if (cantidad <= stock) {
            stock -= cantidad
        } else {
            println("No hay suficiente stock de '$titulo'")
        }
    }

    override fun toString(): String =
        "$titulo - $genero - \$$precio (Stock: $stock) por ${autor.nombre}"
}