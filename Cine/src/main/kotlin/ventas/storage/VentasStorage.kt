package ventas.storage

import com.github.michaelbull.result.Result
import ventas.error.VentaError
import ventas.models.Venta
import java.io.File


interface VentasStorage {
    fun export(venta: Venta, file: File): Result<Unit, VentaError>
}