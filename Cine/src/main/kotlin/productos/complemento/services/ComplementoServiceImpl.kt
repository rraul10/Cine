package productos.complemento.services

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import productos.models.Complemento
import java.io.File
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.andThen
import org.lighthousegames.logging.logging
import productos.complemento.errors.ComplementoError
import productos.complemento.repositories.ComplementoRepository
import productos.complemento.storage.ComplementoStorage

private val logger = logging()

class ComplementoServiceImpl(
    private val complementoRepository: ComplementoRepository,
    private val complementoStorage: ComplementoStorage
): ComplementoService {

    override fun getAll(): Result<List<Complemento>, ComplementoError> {
        logger.debug { "Obteniendo todos los complementos" }
        return Ok(complementoRepository.findAll())
    }

    override fun getByTipo(tipo: String): Result<List<Complemento>, ComplementoError> {
        logger.debug { "Obteniendo complementos por tipo: $tipo" }
        return Ok(complementoRepository.findByTipo(tipo))
    }

    override fun getById(id: String): Result<Complemento, ComplementoError> {
        return complementoRepository.findById(id)
            ?.let { Ok(it) }
            ?: Err(ComplementoError.ComplementoNoEncontrado("Complemento no encontrado con id: $id"))
    }

    override fun create(complemento: Complemento): Result<Complemento, ComplementoError> {
        logger.debug { "Guardando complemento $complemento" }
        val savedComplemento = complementoRepository.save(complemento)
        return Ok(savedComplemento)
    }

    override fun update(id: String, complemento: Complemento): Result<Complemento, ComplementoError> {
        logger.debug { "Actualizando complemento con id: $id" }
        val updatedComplemento = complementoRepository.update(complemento.id, complemento)
        return updatedComplemento?.let { Ok(it) }
            ?: Err(ComplementoError.ComplementoNoActualizado("No se ha podido actualizar el complemento: $id"))
    }

    override fun delete(id: String): Result<Complemento, ComplementoError> {
        logger.debug { "Borrando complemento con id $id" }
        val deletedComplemento = complementoRepository.delete(id)
        return deletedComplemento?.let {
            Ok(it)
        } ?: Err(ComplementoError.ComplementoNoEncontrado("El complemento no ha sido eliminado: $id"))
    }

    override fun import(csvFile: File): Result<List<Complemento>, ComplementoError> {
        logger.debug { "Cargando complemento desde CSV" }
        return complementoStorage.load(csvFile).andThen { complementos->
            complementos.forEach{ com->
                complementoRepository.save(com)
            }
            Ok(complementos)
        }
    }
}