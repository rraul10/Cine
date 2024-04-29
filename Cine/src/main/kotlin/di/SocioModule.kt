package di

import org.koin.dsl.module
import socio.repositories.SocioRepository
import socio.repositories.SocioRepositoryImpl
import socio.service.SocioService
import socio.service.SocioServiceImpl
import socio.validator.SocioValidator

val socioModule = module {
    single <SocioRepository>{ SocioRepositoryImpl( )  }
    single <SocioValidator>{ SocioValidator()  }

    single<SocioService> {
        SocioServiceImpl(get(), get())
    }
}