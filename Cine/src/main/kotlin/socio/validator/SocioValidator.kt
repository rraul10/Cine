package socio.validator

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import socio.errors.SocioError
import socio.models.Socio

class SocioValidator {

    fun validarSocio(socio: Socio): Result<Socio, SocioError> {
        val regex : Regex= Regex("[a-zA-Z]")
        when {
            !socio.nombre.matches(regex) && socio.nombre.isBlank()
            -> Err(SocioError.SocioNombreNoValido("El nombre del socio no tiene un formato válido"))
            else -> return Ok(socio)
        }
        return Ok(socio)
    }


}