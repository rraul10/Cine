package ventas.mappers

import Database.VentaEntity
import productos.models.Complemento
import socio.models.Socio
import ventas.dto.VentasDto
import ventas.models.LineaVenta
import ventas.models.Venta
import java.time.LocalDateTime
import java.util.*

fun VentaEntity.Venta(complemento: Complemento): LineaVenta {
    return LineaVenta(
        id = UUID.fromString(this.id.toString()),
        lineas = lineas,
        createAt = LocalDateTime.parse(this.createAt),
        updateAt = LocalDateTime.parse(this.updateAt),
    )
}

fun VentaEntity.toVenta(socio: Socio, lineas: List<LineaVenta>): Venta {
    return Venta(
        id = UUID.fromString(this.id),
        Socio = socio,
        lineas = lineas,
        createdAt = LocalDateTime.parse(this.createAt),
        updatedAt = LocalDateTime.parse(this.updateAt),
    )
}

fun LineaVenta.toLineaVentaDto(): VentasDto {
    return VentasDto(
        id = this.id.toString(),
        producto = this.producto.toProductoDto(),
        cantidad = this.cantidad,
        precio = this.precio,
        createAt = this.createAt.toString(),
        updateAt = this.updateAt.toString(),
    )
}

fun Venta.toVentaDto(): VentasDto {
    return VentasDto(
        id = this.id.toString(),
         = this.cliente.toClienteDto(),
        lineas = this.lineas.map { it.toLineaVentaDto() },
        total = this.lineas.sumOf { it.precio },
        createdAt = this.createdAt.toString(),
        updatedAt = this.updatedAt.toString(),
    )
}