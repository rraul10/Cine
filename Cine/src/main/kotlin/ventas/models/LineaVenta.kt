package ventas.models

import productos.models.Butaca
import productos.models.Complemento
import productos.models.Producto
import java.time.LocalDateTime
import java.util.*

data class LineaVenta(
    val id: UUID = UUID.randomUUID(),
    val butaca: Butaca,
    val complemento1: Complemento? = null,
    val complemento2: Complemento? = null,
    val complemento3: Complemento? = null,
    val cantidad: Int,
    val precio: Double,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now()
)