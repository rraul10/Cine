package ventas.models

import socio.models.Socio
import java.time.LocalDateTime
import java.util.*

data class Venta(
    val id: UUID = UUID.randomUUID(),
    val socio: Socio,
    val lineas: List<LineaVenta>,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now()
) {
    val total: Double
        get() = lineas.sumOf { it.precio * it.cantidad }

    override fun toString(): String {
        return "Venta(id=$id,socio=$socio,lineas=$lineas,createAt=$createdAt,updateAt=$updatedAt)"
    }
}