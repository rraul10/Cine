package di

import org.example.productos.complementos.storage.ComplementoStorageImpl
import org.koin.dsl.module
import productos.butaca.repositories.ButacasRepository
import productos.butaca.repositories.ButacasRepositoryImpl
import productos.butaca.services.ButacasService
import productos.butaca.services.ButacasServiceImpl
import productos.butaca.storage.ButacasStorage
import productos.butaca.storage.ButacasStorageImpl
import productos.butaca.validator.ButacaValidator
import productos.complemento.repositories.ComplementoRepository
import productos.complemento.repositories.ComplementoRepositoryImpl
import productos.complemento.services.ComplementoService
import productos.complemento.services.ComplementoServiceImpl
import productos.complemento.storage.ComplementoStorage

val butacaModule= module {
    single <ButacasRepository>{ ButacasRepositoryImpl() }
    single <ButacaValidator>{ ButacaValidator() }
    single <ButacasStorage>{ ButacasStorageImpl(get()) }

    single <ButacasService>{
        ButacasServiceImpl(get(), get(), get())
    }
}

val complementoModule = module {
    single <ComplementoRepository>{ ComplementoRepositoryImpl() }
    single <ComplementoStorage>{ ComplementoStorageImpl() }

    single <ComplementoService>{
        ComplementoServiceImpl(get(), get())
    }
}