package ventas.mappers

import Database.VentaEntity
import productos.models.Complemento
import socio.models.Socio
import ventas.dto.VentaDto
import ventas.models.LineaVenta
import ventas.models.Venta
import java.time.LocalDateTime
import java.util.*

fun VentaEntity.toVentaDto(complemento: Complemento): LineaVenta {
    return LineaVenta(
        id = UUID.fromString(this.id.toString()),
        lineas = lineas,
        createdAt = LocalDateTime.parse(this.createdAt),
        updatedAt = LocalDateTime.parse(this.updatedAt),
    )
}

fun VentaEntity.toVenta(socio: Socio, lineas: List<LineaVenta>): Venta {
    return Venta(
        id = UUID.fromString(this.id),
        socio = socio,
        lineas = lineas,
        createdAt = LocalDateTime.parse(this.createdAt),
        updatedAt = LocalDateTime.parse(this.updatedAt),
    )
}

fun LineaVenta.toLineaVentaDto(): VentaDto {
    return VentaDto(
        id = this.id.toString(),
        producto = this.producto.toProductoDto(),
        cantidad = this.cantidad,
        precio = this.precio,
        createdAt = this.createdAt.toString(),
        updatedAt = this.updatedAt.toString(),
    )
}

fun Venta.toVentaDto(): VentaDto {
    return VentaDto(
        id = this.id.toString(),
         = this.socio.toClienteDto(),
        lineas = this.lineas.map { it.toLineaVentaDto() },
        total = this.lineas.sumOf { it.precio },
        createdAt = this.createdAt.toString(),
        updatedAt = this.updatedAt.toString(),
    )
}