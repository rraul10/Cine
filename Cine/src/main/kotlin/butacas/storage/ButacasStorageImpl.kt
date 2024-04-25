package butacas.storage

import Database.ButacaEntity
import butacas.dto.ButacaDto
import butacas.models.Butaca
import org.lighthousegames.logging.logging
import toButaca
import java.io.File

private val logger = logging()

class ButacasStorageImpl : ButacasStorage {
    override fun import(lista: List<Butaca>) {
        TODO("not yet implemented")
    }

    override fun export(file: File): List<Butaca> {
        logger.debug { "Importando archivos" }

        return file.readLines().drop(1).map { line ->
            val parts = line.split(",")
            ButacaEntity(
                id = parts[0],
                estado = parts[1],
                actividad = parts[2],
                tipo = parts[3],
                precio = parts[4].toLong()
            ).toButaca()
        }
    }
}