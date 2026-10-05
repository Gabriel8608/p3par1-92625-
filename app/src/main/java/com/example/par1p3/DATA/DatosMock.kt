package com.example.par1p3.data

import com.example.par1p3.model.Autor
import com.example.par1p3.model.Cliente
import com.example.par1p3.model.Libreria
import com.example.par1p3.model.Libro
import com.example.par1p3.model.Venta

object DatosMock {

    val autores = listOf(
        Autor(1, "Gabriel García Márquez", "Colombiana"),
        Autor(2, "J.K. Rowling", "Británica"),
        Autor(3, "Jorge Luis Borges", "Argentina"),
        Autor(4, "Isabel Allende", "Chilena")
    )

    val libros = listOf(
        Libro("978-1", "Cien años de soledad", "Novela", 25.0, 5, autores[0]),
        Libro("978-2", "Harry Potter y la piedra filosofal", "Fantasía", 30.0, 8, autores[1]),
        Libro("978-3", "El Aleph", "Cuento", 20.0, 3, autores[2]),
        Libro("978-4", "La casa de los espíritus", "Novela", 22.5, 6, autores[3]),
        Libro("978-5", "Harry Potter y la cámara secreta", "Fantasía", 32.0, 4, autores[1])
    )

    val clientes = listOf(
        Cliente(1, "Ana Pérez", "ana@mail.com", "77712345"),
        Cliente(2, "Luis Gómez", "luis@mail.com", "77798765"),
        Cliente(3, "María Rojas", "maria@mail.com", "77755555")
    )

    val ventas = listOf(
        Venta(1, clientes[0], listOf(libros[0], libros[2]), "2025-10-01"),
        Venta(2, clientes[1], listOf(libros[1]), "2025-10-02"),
        Venta(3, clientes[2], listOf(libros[3], libros[4]), "2025-10-03")
    )

    fun obtenerLibreria(): Libreria {
        val libreria = Libreria("Librería Central")
        libros.forEach { libreria.agregarLibro(it) }
        ventas.forEach { libreria.registrarVenta(it) }
        return libreria
    }
}