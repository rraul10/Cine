package ventas.service

import ventas.error.VentaError
import ventas.models.Venta
import java.io.File
import com.github.michaelbull.result.Result
import ventas.models.LineaVenta
import java.util.*

interface VentasService {
    fun getById(id: UUID): Result<Venta, VentaError>
    fun create(venta: Venta): Result<Venta, VentaError>
    fun create(venta: Venta, lineas: List<LineaVenta>): Result<Venta, VentaError>
    fun exportToHtml(venta: Venta, htmlFile: File): Result<Unit, VentaError>
}