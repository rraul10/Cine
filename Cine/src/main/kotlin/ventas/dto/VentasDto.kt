package ventas.dto

import butacas.dto.ButacaDto
import kotlinx.serialization.Serializable

data class VentasDto(
    val id: String,
    val butaca: ButacaDto,
    val lineas: List<LineaVentasDto>,
    val total: Double,
    val createdAt: String,
    val updatedAt: String,
)