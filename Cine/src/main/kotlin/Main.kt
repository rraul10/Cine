import productos.butaca.models.Actividad
import productos.butaca.models.Butaca
import productos.butaca.models.Estado
import productos.butaca.models.Tipo
import productos.butaca.validator.ButacaValidator

fun main(){
    println()
    val butaca = Butaca("A4", Estado.LIBRE, Actividad.ACTIVA, Tipo.NORMAL)
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

