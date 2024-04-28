package ventas.repositories

import org.example.database.SqlDelightManager
import org.lighthousegames.logging.logging
import productos.butaca.repositories.ButacasRepository
import productos.complemento.repositories.ComplementoRepository
import socio.repositories.SocioRepository
import ventas.mappers.toLineaVenta
import ventas.mappers.toVenta
import ventas.models.Venta
import java.util.*

private val logger = logging()

class VentasRepositoryImpl(
    private val clienteRepository: SocioRepository,
    private val butacasRepository: ButacasRepository,
    private val complementosRepository: ComplementoRepository
) : VentasRepository {

    private val db = SqlDelightManager().databaseQueries

    override fun findAll(): List<Venta> {
        logger.debug { "Buscar todas las ventas" }
//        return db.selectAllVenta().executeAsList().map { it.toVenta() }
        TODO("Averiguar como se hace")
    }

    override fun findById(id: UUID): Venta? {
        logger.debug { "Obteniendo venta por id: $id" }
        if(db.existsVenta(id.toString()).executeAsOne()){
            val ventaEntity = db.selectVentaById(id.toString()).executeAsOne()
            val cliente = clienteRepository.findById(ventaEntity.socio_id)!!
            val lineaVenta = db.selectAllLineasVentaByVentaId(ventaEntity.id).executeAsList()
                .map { it.toLineaVenta(butacasRepository.findById(it.Butaca_id)!!,
                    complemento1 = complementosRepository.findById(it.Complemento1_id.toString()),
                    complemento2 = complementosRepository.findById(it.Complemento2_id.toString()),
                    complemento3 = complementosRepository.findById(it.Complemento3_id.toString()))
                }
            return ventaEntity.toVenta(cliente, lineaVenta)
        }
        return null
    }

    override fun save(venta: Venta): Venta {
        logger.debug { "Guardando venta: $venta" }
        db.transaction {
            db.insertVenta(
                id = venta.id.toString(),
                socio_id = venta.socio.id,
                total = venta.total,
                created_at = venta.createdAt.toString(),
                updated_at = venta.updatedAt.toString()
            )
        }
        venta.lineas.forEach {
            db.transaction {
                db.insertLineaVenta(
                    id = it.id.toString(),
                    venta_id = venta.id.toString(),
                    Butaca_id = it.butaca.id,
                    Complemento1_id = it.complemento1?.id?.toLong(),
                    Complemento2_id = it.complemento2?.id?.toLong(),
                    Complemento3_id = it.complemento3?.id?.toLong(),
                    cantidad = it.cantidad.toLong(),
                    precio = it.precio,
                    created_at = it.createdAt.toString(),
                    updated_at = it.updatedAt.toString()
                )
            }
        }
        return venta
    }

    override fun update(id: UUID, venta: Venta): Venta? {
        logger.debug { "Acualizando venta por id: $id" }
        findById(id)?.let {
            db.transaction { db.updateVenta(id = venta.id.toString(), socio_id = venta.socio.id, total = venta.total, updated_at = venta.updatedAt.toString(), is_deleted = 0) }
        }
        return venta
    }

    override fun delete(id: UUID): Venta? {
        logger.debug { "Borrando venta por id: $id" }
        val delted = findById(id)
        findById(id)?.let {
            db.transaction {
                db.deleteVenta(id.toString())
            }
        }
        return delted
    }

}