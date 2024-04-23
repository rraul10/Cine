package butacas.repositories

import butacas.models.Butaca
import org.example.database.SqlDelightManager
import org.lighthousegames.logging.logging

private val logger = logging()

class ButacasRepositoryImpl: ButacasRepository {

    private val db = SqlDelightManager().databaseQueries

    override fun findAll(): List<Butaca> {
        TODO("Not yet implemented")
    }

    override fun findById(id: String): Butaca? {
        TODO("Not yet implemented")
    }

    override fun save(butaca: Butaca): Butaca {
        TODO("Not yet implemented")
    }

    override fun update(id: String, butaca: Butaca): Butaca? {
        TODO("Not yet implemented")
    }

    override fun delete(id: String): Butaca? {
        TODO("Not yet implemented")
    }
}