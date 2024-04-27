package ventas.dto

import butacas.dto.ButacaDto


data class VentasDto(
    val id: String,
    val butaca: ButacaDto,
    val lineas: List<LineaVentasDto>,
    val total: String,
    val createdAt: String,
    val updatedAt: String,
)