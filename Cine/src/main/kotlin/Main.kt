import butacas.models.Actividad
import butacas.models.Butaca
import butacas.models.Estado
import butacas.models.Tipo
import butacas.validator.ButacaValidator
import java.io.ObjectInputFilter.Config

fun main(){
    println()
    val butaca = Butaca("A4",Estado.LIBRE, Actividad.ACTIVA, Tipo.NORMAL)
    val butacaValidator = ButacaValidator()
    println( butacaValidator.validate(butaca))

    
    var opcion: Int

    do {
        println("1. Ver sala")
        println("2. Comprar Entrada")
        println("3. Devolver Entrada")
        println("4. Ver Recaudación")
        println("0. Salir")

        opcion = readln().toIntOrNull() ?: -1

//        when (opcion) {
//            1 -> //imprimirSala()
//            2 -> comprarEntrada()
//            3 -> devolverEntrada()
//            4 -> verRecaudacion()
//            0 -> despedida()
//            else -> println("Opción no válida")
//        }

    } while (opcion != 0)

}

