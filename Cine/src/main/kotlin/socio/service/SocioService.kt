package socio.service

import com.github.michaelbull.result.Result
import socio.errors.SocioError
import socio.models.Socio

interface SocioService {
    fun getAll(): Result<List<Socio>,SocioError>
    fun getById(id: String): Result<Socio,SocioError>
    fun save(socio: Socio): Result<Socio,SocioError>
    fun update(id: String, socio: Socio): Result<Socio,SocioError>
    fun delete(id: String): Result<Socio,SocioError>
}