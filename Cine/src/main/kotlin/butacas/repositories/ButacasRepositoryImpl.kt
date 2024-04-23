package butacas.repositories

import butacas.models.Butaca
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
        TODO()
    }

    override fun update(id: String, butaca: Butaca): Butaca? {
        TODO("Not yet implemented")
    }

    override fun delete(id: String): Butaca? {
        TODO("Not yet implemented")
    }
}