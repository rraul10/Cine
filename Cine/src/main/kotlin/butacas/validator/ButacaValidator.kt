package butacas.validator

import butacas.errors.ButacaError
import butacas.models.Butaca
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import org.lighthousegames.logging.logging

private val logger = logging()

class ButacaValidator {

    fun validate(butaca: Butaca): Result<Butaca, ButacaError> {
        logger.debug{"Validando butaca"}
        return if (!esValidaButaca(butaca.id)) {
            Err(ButacaError.ButacaNotValid("La butaca no es valida"))
        } else {
            Ok(butaca)
        }
    }


    fun esValidaButaca(id: String): Boolean {
        val regex = Regex("[A-F][1-7]")
        return regex.matches(id)
    }

}