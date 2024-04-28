package ventas.mappers

import Database.LineaVentaEntity
import Database.VentaEntity
import productos.models.Butaca
import productos.models.Complemento
import socio.models.Socio
import ventas.models.LineaVenta
import ventas.models.Venta
import java.time.LocalDateTime
import java.util.*

fun VentaEntity.toVenta(socio: Socio, lineas: List<LineaVenta>): Venta {
    return Venta(
        id = UUID.fromString(this.id),
        socio = socio,
        lineas = lineas,
        createdAt = LocalDateTime.parse(this.created_at),
        updatedAt = LocalDateTime.parse(this.updated_at),
    )
}

fun LineaVentaEntity.toLineaVenta(Butaca: Butaca, complemento1: Complemento?, complemento2: Complemento?, complemento3: Complemento?): LineaVenta {
    return LineaVenta(
        id = UUID.fromString(this.id),
        butaca = Butaca,
        complemento1 = complemento1,
        complemento2 = complemento2,
        complemento3 = complemento3,
        cantidad = this.cantidad.toInt(),
        precio = this.precio,
        createdAt = LocalDateTime.parse(this.created_at),
        updatedAt = LocalDateTime.parse(this.updated_at),
    )
}