import config.Config
import di.butacaModule
import di.complementoModule
import di.socioModule
import di.ventasModule
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.context.GlobalContext.startKoin
import org.koin.fileProperties
import productos.models.Actividad
import productos.models.Butaca
import productos.models.Estado
import productos.models.Tipo
import productos.butaca.validator.ButacaValidator


@OptIn(KoinExperimentalAPI::class)
fun main(){

    fun main() {

        startKoin {
            printLogger()
            fileProperties("/config.properties")
            modules(listOf(socioModule, butacaModule, complementoModule, ventasModule))
        }

        val app= CineApp()
        app.run()


    }
}

