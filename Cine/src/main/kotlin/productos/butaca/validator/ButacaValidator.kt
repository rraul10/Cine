package productos.butaca.validator

import org.lighthousegames.logging.logging
import productos.butaca.exceptions.ButacaException
import productos.butaca.models.Butaca

private val logger= logging()

class ButacaValidator {

    fun validate(butaca: Butaca): Butaca {
        logger.debug { "Validando butaca" }

        if (!esValidaButaca(butaca.id)) {
            logger.error { "Butaca invalida" }
            throw ButacaException.ButacaNoValida("La butaca con ID ${butaca.id} no es válida")
        }

        return butaca
    }

    private fun esValidaButaca(id: String): Boolean {
        val regex = Regex("[A-F][1-7]")
        return regex.matches(id)
    }

    fun validarFecha(fecha: String): Boolean {
        val regex = Regex("\\d{4}/\\d{2}/\\d{2}")
        return regex.matches(fecha)
    }

}