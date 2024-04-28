package productos.butaca.services

import productos.butaca.exceptions.ButacaException
import productos.models.Butaca
import productos.butaca.repositories.ButacasRepository
import org.lighthousegames.logging.logging
import productos.butaca.storage.ButacasStorage
import productos.butaca.validator.ButacaValidator
import java.io.File

private val logger = logging()

class ButacasServiceImpl(
    private val butacaRepository: ButacasRepository,
    private val butacaValidator: ButacaValidator,
    private val butacaStorage: ButacasStorage
): ButacasService {
    override fun getAll(): List<Butaca> {
        logger.debug { "Obteniendo las butacas" }
        return butacaRepository.findAll()
    }

    override fun getById(id: String): Butaca {
        logger.debug { "Butaca encontrada con id: $id" }
        return butacaRepository.findById(id)?: throw ButacaException.ButacadNoEncontrada("Butaca no enontrada")
    }

    override fun create(butaca: Butaca): Butaca {
        logger.debug { "Butaca encontrada con id: ${butaca.id}" }
        return butacaRepository.save(butaca)
    }

    override fun update(id: String, butaca: Butaca): Butaca {
        logger.debug { "Actualizando la butaca: $butaca" }
        return butacaRepository.update(id,butaca)?: throw ButacaException.ButacaNoValida("Butaca no actualizada")
    }

    override fun delete(id: String): Butaca {
        logger.debug { "Eliminando la butaca con id: $id" }
        return butacaRepository.delete(id)?: throw ButacaException.ButacaNoValida("Butaca no eliminada")
    }

    override fun import(csvFile: File): List<Butaca> {
        logger.debug { "Cargando butacas desde un fichero CSV" }
        val butacas = butacaStorage.load(csvFile)
        butacas.forEach { butaca ->
            butacaRepository.save(butaca)
        }
        return butacas
    }


    override fun export(fecha: String, listaButacas: List<Butaca>) {
        logger.debug { "Guardando butacas en JSON" }
        return butacaStorage.save(fecha,listaButacas)
    }


}