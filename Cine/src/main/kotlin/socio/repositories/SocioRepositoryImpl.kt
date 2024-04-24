package socio.repositories

import org.lighthousegames.logging.logging
import socio.models.Socio
import java.time.LocalDateTime

private val logger = logging()

class SocioRepositoryImpl(
    private val dbManager: SqlDeLightManager
) : SocioRepository {
    private val db = dbManager.databaseQueries

    override fun findAll(): List<Socio> {
        logger.debug { "Buscando todos los socios" }
        return db.selectAllClientes().executeAsList().map { it.toCliente() }
    }

    override fun findById(id: Long): Socio? {
        logger.debug { "Buscando cliente por id: $id" }
        return db.selectClienteById(id).executeAsOneOrNull()?.toCliente()
    }

    override fun save(socio: Socio): Socio {
        logger.debug { "Guardando socio: $socio" }

        val timeStamp = LocalDateTime.now().toString()

        db.transaction {
            db.insertCliente(
                nombre = socio.nombre,
                email = socio.gmail,
                created_at = timeStamp,
                updated_at = timeStamp,
            )
        }

        return db.selectClienteLastInserted().executeAsOne().toCliente()
    }

    override fun update(id: Long, socio: Socio): Socio? {
        logger.debug { "Actualizando cliente por id: $id" }
        var result = this.findById(id) ?: return null
        val timeStamp = LocalDateTime.now()
        result = result.copy(
            nombre = socio.nombre,
            gmail = socio.gmail,
            isDeleted = socio.isDeleted,
            updatedAt = timeStamp
        )

        db.updateCliente(
            nombre = result.nombre,
            gmail = result.gmail,
            updated_at = timeStamp.toString(),
            is_deleted = if (result.isDeleted) 1 else 0,
            id = id,
        )
        return result
    }

    override fun delete(id: Long): Socio? {
        logger.debug { "Borrando cliente por id: $id" }
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