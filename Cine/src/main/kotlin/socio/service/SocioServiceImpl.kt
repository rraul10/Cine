package socio.service

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import org.lighthousegames.logging.logging
import socio.errors.SocioError
import socio.models.Socio
import socio.repositories.SocioRepository
import socio.validator.SocioValidator

private val logger = logging()

class SocioServiceImpl(
    val socioRepository: SocioRepository,
    val socioValidator: SocioValidator
): SocioService {
    override fun getAll(): Result<List<Socio>, SocioError> {
        logger.debug { "Obteniendo todos los socios" }
        return Ok(socioRepository.findAll())
    }

    override fun getById(id: String): Result<Socio, SocioError> {
        logger.debug { "Obteniendo socio por id: $id" }
        val socio = socioRepository.findById(id)
        return if (socio != null) {
            Ok(socio)
        } else {
            Err(SocioError.SocioIdNoValido("El socio con el ID $id no fue encontrado"))
        }
    }

    override fun save(socio: Socio): Result<Socio, SocioError> {
        logger.debug { "Guardando el socio $socio" }
        return Ok(socioRepository.save(socio))
    }

    override fun update(id: String, socio: Socio): Result<Socio, SocioError> {
        logger.debug { "Actualizando el socio $id" }
        val updatedSocio = socioRepository.update(id, socio)
        return if (updatedSocio != null) {
            Ok(updatedSocio)
        } else {
            Err(SocioError.SocioNoValido("No se pudo actualizar el socio con el ID $id"))
        }
    }

    override fun delete(id: String): Result<Socio, SocioError> {
        logger.debug { "Borrando socio con id: $id" }
        val deletedSocio = socioRepository.delete(id)
        return if (deletedSocio != null) {
            Ok(deletedSocio)
        } else {
            Err(SocioError.SocioNoValido("No se pudo eliminar el socio con el ID $id"))
        }
    }
}