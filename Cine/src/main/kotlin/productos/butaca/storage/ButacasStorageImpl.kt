package productos.butaca.storage

import Database.ButacaEntity
import productos.butaca.dto.ButacaDto
import productos.butaca.exceptions.ButacaException
import productos.models.Butaca
import productos.butaca.validator.ButacaValidator
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.lighthousegames.logging.logging
import toButaca
import toButacaDto
import java.io.File
import java.nio.file.Files
import kotlin.io.path.Path

private val logger = logging()

class ButacasStorageImpl(
    private val validador: ButacaValidator
) : ButacasStorage {
    override fun save(fecha:String, lista: List<Butaca>) {
        if (!validador.validarFecha(fecha)) throw ButacaException.ButacaFechaNoValida("La fecha no es valida")
        logger.debug { "Guardando la butaca en fichero JSON" }
        Files.createDirectory(Path("data"))
        val file = Path("data", "butacas-$fecha.json").toFile()

        return try {
            val json = Json{
                prettyPrint = true
                ignoreUnknownKeys = true
            }
            file.writeText(json.encodeToString<List<ButacaDto>>(lista.map { it.toButacaDto() }))
        }catch (e: Exception) {
            logger.error { "Error al guardar el fichero Json" }
            throw ButacaException.FicheroNoValidado("Error al guardar el fichero json")
        }
    }

    override fun load(file: File): List<Butaca> {
        logger.debug { "Importando archivos" }
        return try {
            file.readLines().drop(1).map { line ->
                val parts = line.split(",")
                ButacaEntity(
                    id = parts[0],
                    estado = parts[1],
                    actividad = parts[2],
                    tipo = parts[3],
                    precio = parts[4].toLong()
                ).toButaca()
            }
        }catch (e: Exception){
            logger.error { "Error al leer el fichero CSV" }
            throw ButacaException.FicheroNoValidado("Error al leer el fichero CSV")
        }
        }
}