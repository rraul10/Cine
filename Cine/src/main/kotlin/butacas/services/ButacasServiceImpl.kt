package butacas.services

import butacas.exceptions.ButacaException
import butacas.models.Butaca
import butacas.repositories.ButacasRepository
import com.github.michaelbull.result.Result
import org.lighthousegames.logging.logging
import java.io.File
import kotlin.math.log

private val logger = logging()

class ButacasServiceImpl(
    private val butacasRepository: ButacasRepository
): ButacasService {
    override fun getAll(): List<Butaca> {
        logger.debug { "Obteniendo las butacas" }
        return butacasRepository.findAll()
    }

    override fun getById(id: String): Butaca {
        logger.debug { "Butaca encontrada con id: $id" }
        return butacasRepository.findById(id)?: throw ButacaException.ButacadNoEncontrada("Butaca no enontrada")
    }

    override fun create(butaca: Butaca): Butaca {
        logger.debug { "Butaca encontrada con id: ${butaca.id}" }
        return butacasRepository.save(butaca)
    }

    override fun update(id: String, butaca: Butaca): Butaca {
        TODO("Not yet implemented")
    }

    override fun delete(id: String): Butaca {
        TODO("Not yet implemented")
    }

    override fun import(csvFile: File) {
        TODO("Not yet implemented")
    }

    override fun export(butacas: List<Butaca>): File {
        TODO("Not yet implemented")
    }

}