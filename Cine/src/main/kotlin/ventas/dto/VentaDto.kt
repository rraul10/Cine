package ventas.dto

import socio.dto.SocioDto

data class VentaDto(
    val id: String,
    val socio: SocioDto,
    val lineas: List<LineaVentaDto>,
    val total: String,
    val createdAt: String,
    val updatedAt: String,
)