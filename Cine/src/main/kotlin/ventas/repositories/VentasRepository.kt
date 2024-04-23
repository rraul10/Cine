package ventas.repositories

import ventas.models.Venta
import java.util.*

interface VentasRepository {
    fun findAll(): List<Venta>
    fun findById(id: UUID): Venta?
    fun save(venta: Venta): Venta
    fun update(id: UUID, venta: Venta): Venta?
    fun delete(id: Venta): Venta?
}