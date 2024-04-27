package socio.repositories

import database.DataBaseManager
import org.lighthousegames.logging.logging
import socio.models.Socio
import java.sql.ResultSet

private val logger = logging()

class SocioRepositoryImpl : SocioRepository {

    private fun ResultSet.toSocio(): Socio {
        return Socio(
            id = getString("id"),
            nombre = getString("nombre"),
            is_deleted = getBoolean("is_deleted")
        )
    }
    override fun findAll(): List<Socio> {
        logger.debug { "Obteniendo todos los socios" }
        val result = mutableListOf<Socio>()
        DataBaseManager.use { db ->
            val sql = "SELECT * FROM Socio"
            val statement = db.connection?.prepareStatement(sql)!!
            val rs = statement.executeQuery()
            while (rs.next()) result.add(rs.toSocio())
        }
        return result
    }

    override fun findById(id: String): Socio? {
        logger.debug { "Obteniendo socio por el el id: $id" }
        var result : Socio? = null
        DataBaseManager.use { db->
            val sql= "SELECT * FROM Socio WHERE id = ?"
            val statement = db.connection?.prepareStatement(sql)!!
            val rs= statement.executeQuery()
            while (rs.next())result= rs.toSocio()
        }
    return result
    }

    override fun save(socio: Socio): Socio {
        logger.debug { "Guardando socio $socio" }
        val result: Socio = socio
        DataBaseManager.use { db->
            val sql = "SELECT * FROM Socio (id,nombre) VALUES (?,?)"
            val statement = db.connection?.prepareStatement(sql)!!.apply {
                setString(1,socio.id)
                setString(2,socio.nombre)
                setBoolean(3,socio.is_deleted)
            }
            val rs = statement.executeUpdate()
        }
        return result
    }

    override fun update(id: String, socio: Socio): Socio? {
        logger.debug { "Actualizando socio con id: $id" }
        var result: Socio = this.findById(id) ?: return null
        DataBaseManager.use { db->
            val sql = "UPDATE Socio SET nombre = ? WHERE id = ?"
            val statement = db.connection?.prepareStatement(sql)!!.apply {
                setString(1,socio.nombre)
                setString(2,socio.id)
            }
            val rs = statement.executeUpdate()
            if (rs>0) result = result.copy(is_deleted = true)
        }
        return result
    }

    override fun delete(id: String): Socio? {
        logger.debug { "Borrando socio con id: $id" }
        var result : Socio = this.findById(id) ?: return null
        DataBaseManager.use { db->
            val sql = "DELETE FROM Socio WHERE id = ?"
            val statement = db.connection?.prepareStatement(sql)!!.apply {
                setString(1, id)
            }
            val rs = statement.executeUpdate()
            if (rs>0) result = result.copy(is_deleted = true)
        }
        return result
    }
}