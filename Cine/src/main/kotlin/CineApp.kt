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

private val logger = logging()

class CineApp : KoinComponent{

    fun run(){
        val butacaRepository: ButacasRepository by inject()
        val butacaService: ButacasService by inject()
        val socioRepository: SocioRepository by inject()
        val socioService: SocioService by inject()
        val ventaRepository: VentasRepository by inject()
        val ventaService: VentasService by inject()

        val sqlDelightManager : SqlDelightManager by inject()

        sqlDelightManager.initialize()

        println("BIENVENIDO AL CINE DE DAW")

        do {
            println("Menú del cine")
            println(" 1: Comprar entrada")
            println(" 2: Devolver entrada")
            println(" 3: Estado del cine")
            println(" 4: Obtener recaudación")
            println(" 5: Importar complementos")
            println(" 7: Exportar estado del cine")
            println(" 7: Configurar butacas")
            println(" 8: Salir")
            println("Selecciona una opción válida")
            val option = readln().toIntOrNull() ?: -1

        }while (option!=8)
    }

}

