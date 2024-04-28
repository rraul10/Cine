package ventas.models

import productos.models.Butaca
import java.time.LocalDateTime
import java.util.*

data class LineaVenta(
    val id: UUID = UUID.randomUUID(),
    val butaca: Butaca,
    val cantidad: Int,
    val precio: Double,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now()
)