package productos.butaca.services

import productos.butaca.exceptions.ButacaException
import productos.models.Butaca
import productos.butaca.repositories.ButacasRepository
import org.lighthousegames.logging.logging

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
        logger.debug { "Actualizando la butaca: $butaca" }
        return butacasRepository.update(id,butaca)?: throw ButacaException.ButacaNoValida("Butaca no actualizada")
    }

    override fun delete(id: String): Butaca {
        logger.debug { "Eliminando la butaca con id: $id" }
        return butacasRepository.delete(id)?: throw ButacaException.ButacaNoValida("Butaca no eliminada")
    }

}