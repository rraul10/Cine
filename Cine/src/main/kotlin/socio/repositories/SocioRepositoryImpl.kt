package socio.repositories

import org.lighthousegames.logging.logging
import socio.models.Socio
import java.time.LocalDateTime

private val logger = logging()

class SocioRepositoryImpl(
    private val dbManager: SqlDeLightManager
) : ClientesRepository {
    private val db = dbManager.databaseQueries

    override fun findAll(): List<Socio> {
        logger.debug { "Buscando todos los socios" }
        return db.selectAllSocio().executeAsList().map { it.toSocio() }
    }

    override fun findById(id: Long): Socio? {
        logger.debug { "Buscando socio por id: $id" }
        return db.selectSocioById(id).executeAsOneOrNull()?.toSocio()
    }

    override fun save(socio: Socio): Socio {
        logger.debug { "Guardando socio: $socio" }

        val timeStamp = LocalDateTime.now().toString()

        db.transaction {
            db.insertSocio(
                nombre = socio.nombre,
                gmail = socio.gmail,
                created_at = timeStamp,
                updated_at = timeStamp,
            )
        }

        return db.selectSocioLastInserted().executeAsOne().toSocio()
    }

    override fun update(id: Long, socio: Socio): Socio? {
        logger.debug { "Actualizando socio por id: $id" }
        var result = this.findById(id) ?: return null
        val timeStamp = LocalDateTime.now()
        result = result.copy(
            nombre = socio.nombre,
            gmail = socio.gmail,
            isDeleted = socio.isDeleted,
            updatedAt = timeStamp
        )

        db.updateSocio(
            nombre = result.nombre,
            gmail = result.gmail,
            updated_at = timeStamp.toString(),
            is_deleted = if (result.isDeleted) 1 else 0,
            id = id,
        )
        return result
    }

    override fun delete(id: Long): Socio? {
        logger.debug { "Borrando socio por id: $id" }
        val result = this.findById(id) ?: return null
        // Esto es borrado lógico
        val timeStamp = LocalDateTime.now()
        db.updateCliente(
            nombre = result.nombre,
            gmail = result.gmail,
            is_deleted = 1,
            updated_at = timeStamp.toString(),
            id = result.id,
        )
        return result.copy(isDeleted = true, updatedAt = timeStamp)
    }

}