import org.example.database.SqlDelightManager
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.lighthousegames.logging.logging
import productos.butaca.repositories.ButacasRepository
import productos.butaca.services.ButacasService
import socio.repositories.SocioRepository
import socio.service.SocioService
import ventas.repositories.VentasRepository
import ventas.service.VentasService
import java.io.File

private val logger = logging()

class CineApp : KoinComponent{

    fun run(){
        val butacaRepository: ButacasRepository by inject()
        val butacaService: ButacasService by inject()
        val socioRepository: SocioRepository by inject()
        val socioService: SocioService by inject()
        val ventaRepository: VentasRepository by inject()
        val ventaService: VentasService by inject()


        println("BIENVENIDO AL CINE DE DAW")

        do {
            println("-.-.-.-.-.-.-.-.-.-.-.-.-.-Menú del cine-.-.-.-.-.-.-.-.-.-.-.-.-.-")
            println(" 1: Comprar entrada")
            println(" 2: Devolver entrada")
            println(" 3: Estado del cine")
            println(" 4: Obtener recaudación")
            println(" 5: Importar complementos")
            println(" 7: Exportar estado del cine")
            println(" 7: Configurar butacas")
            println(" 8: Salir")
            val option = readln().toIntOrNull() ?: -1

            if (option !in 1..8) println("Introduce un valor válido")

            when (option) {
                1 -> println("ds")//comprarEntrada(productoService, clienteRepository, ventaService)
                2 -> println("ds")//devolverEntrada(ventaRepository, productoService, ventaService)
                3 -> println()
                4 -> println("ds")//dqwdwq
                5 -> println("ds")//wqdqw
                6 -> println("ds")//dad
                7 -> configurarButaca(butacaService)
            }


        }while (option!=8)


    }

    private fun configurarButaca(butacasService: ButacasService) {
        println("IMPORTAR BUTACAS")
        val file= File("data","butacas.csv")
        butacasService.import(file)

    }

}

