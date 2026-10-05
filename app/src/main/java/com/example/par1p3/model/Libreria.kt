package par1p3.model

class Libreria(
    val nombre: String,
    private val libros: MutableList<Libro> = mutableListOf(),
    private val ventas: MutableList<Venta> = mutableListOf()
) {

    fun agregarLibro(libro: Libro) {
        libros.add(libro)
    }

    fun buscarLibroPorTitulo(titulo: String): Libro? {
        return libros.firstOrNull { it.titulo.equals(titulo, ignoreCase = true) }
    }

    fun registrarVenta(venta: Venta) {
        venta.libros.forEach { it.reducirStock(1) }
        ventas.add(venta)
    }

    fun listarLibros(): List<Libro> = libros

    fun listarVentas(): List<Venta> = ventas

    override fun toString(): String =
        "Librería '$nombre' | Libros: ${libros.size} | Ventas: ${ventas.size}"
}