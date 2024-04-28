package productos.butaca.repositories

import productos.models.Butaca
import org.example.database.SqlDelightManager
import org.lighthousegames.logging.logging
import toButaca

private val logger = logging()

class ButacasRepositoryImpl: ButacasRepository {

    private val db = SqlDelightManager().databaseQueries

    override fun findAll(): List<Butaca> {
        logger.debug { "Obteniendo todas las butacas" }
        return db.selectAllButacaEntity().executeAsList().map { it.toButaca()}
    }

    override fun findById(id: String): Butaca? {
        logger.debug { "Obtendo butaca por id: $id" }
        return db.selectButacaEntityById(id).executeAsOneOrNull()?.toButaca()
    }

    override fun save(butaca: Butaca): Butaca {
        logger.debug { "Salvando butaca: $butaca" }
        db.transaction {
            db.insertButacaEntity(
                id = butaca.id,
                estado = butaca.estado.toString(),
                actividad = butaca.actividad.toString(),
                tipo = butaca.tipo.toString(),
                precio = butaca.precio.toLong()
            )
        }
        return butaca
    }

    override fun update(id: String, butaca: Butaca): Butaca? {
        logger.debug { "Actualizando butaca: $butaca" }
        var result = this.findById(id) ?: return null

        result = result.copy(
            id = butaca.id,
            estado = butaca.estado,
            actividad = butaca.actividad,
            tipo = butaca.tipo
        )

        db.updateButacaEntity(
            id = butaca.id,
            estado = butaca.estado.toString(),
            actividad = butaca.actividad.toString(),
            tipo = butaca.tipo.toString(),
            precio = butaca.precio.toLong()
        )
        return butaca
    }

    override fun delete(id: String): Butaca? {
        logger.debug { "Eliminando butaca: $id" }
        var result = this.findById(id) ?: return null

        db.deleteButacaEntityById(id)
        return result
    }
}