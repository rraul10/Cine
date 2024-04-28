package ventas.dto

import productos.butaca.dto.ButacaDto


data class LineaVentaDto(
    val id: String,
    val producto: ProductoDto,
    val cantidad: String,
    val precio: String,
    val createdAt: String,
    val updatedAt: String
)