package ventas.models

import java.time.LocalDateTime
import java.util.*

data class Venta(
    val id: UUID = UUID.randomUUID(),
    val lineas: List<LineaVentas>,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now()
) {
    val total: Double
        get() = lineas.sumOf { it.precio * it.cantidad }

    override fun toString(): String {
        return "Venta(id=$id,lineas=$lineas,createAt=$createdAt,updateAt=$updatedAt)"
    }
}