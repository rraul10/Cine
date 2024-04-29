package di

import org.koin.dsl.module
import org.lighthousegames.logging.logging
import socio.repositories.SocioRepository
import socio.repositories.SocioRepositoryImpl
import socio.service.SocioService
import socio.service.SocioServiceImpl
import socio.validator.SocioValidator

private val logger = logging()

val socioModule = module {
    logger.debug { "Modulo de socio" }
    single <SocioRepository>{ SocioRepositoryImpl( )  }
    single <SocioValidator>{ SocioValidator()  }

    single<SocioService> {
        SocioServiceImpl(get(), get())
    }
}