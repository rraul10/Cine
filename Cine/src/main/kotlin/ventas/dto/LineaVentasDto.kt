package ventas.dto

import butacas.dto.ButacaDto
import kotlinx.serialization.Serializable

data class LineaVentasDto(
    val id: String,
    val butacas: ButacaDto,
    val cantidad: Int,
    val precio: Double,
    val createAt: String,
    val updateAt: String
)