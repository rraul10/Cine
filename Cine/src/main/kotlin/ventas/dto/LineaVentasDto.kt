package ventas.dto

import butacas.dto.ButacaDto


data class LineaVentasDto(
    val id: String,
    val butacas: ButacaDto,
    val cantidad: String,
    val precio: String,
    val createAt: String,
    val updateAt: String
)