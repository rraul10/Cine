import butacas.models.Actividad
import butacas.models.Butaca
import butacas.models.Estado
import butacas.models.Tipo
import butacas.validator.ButacaValidator

fun main(){

    val butaca = Butaca("H4",Estado.LIBRE, Actividad.ACTIVA, Tipo.NORMAL)

    val butacaValidator = ButacaValidator()

    println( butacaValidator.validate(butaca))

}