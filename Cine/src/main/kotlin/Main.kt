
import di.butacaModule
import di.complementoModule
import di.socioModule
import di.ventasModule
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.context.GlobalContext.startKoin
import org.koin.fileProperties


@OptIn(KoinExperimentalAPI::class)
fun main(){

        startKoin {
            printLogger()
            fileProperties("/config.properties")
            modules(socioModule, butacaModule, complementoModule, ventasModule)
        }

        val app= CineApp()
        app.run()


}

