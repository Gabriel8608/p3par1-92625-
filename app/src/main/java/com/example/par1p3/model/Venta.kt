package par1p3.model

class Venta(
    val id: Int,
    val cliente: Cliente,
    val libros: List<Libro>,
    val fecha: String
) {
    val total: Double = calcularTotal()

    private fun calcularTotal(): Double {
        var suma = 0.0
        for (libro in libros) {
            suma += libro.precio
        }
        return suma
    }

    override fun toString(): String =
        "Venta #$id - ${cliente.nombre} - $${"%.2f".format(total)} ($fecha)"
}