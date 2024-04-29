package di


import org.koin.dsl.module
import ventas.repositories.VentasRepository
import ventas.repositories.VentasRepositoryImpl
import ventas.service.VentasService
import ventas.service.VentasServiceImpl
import ventas.storage.VentasStorageHtml

val ventasModule = module {
    single <VentasRepository>{
        VentasRepositoryImpl(
            clienteRepository = get(),
            butacasRepository = get(),
            complementosRepository = get()
        )
    }

    single <VentasStorageHtml>{ VentasStorageHtml() }

    single <VentasService>{
        VentasServiceImpl(
            ventasRepository = get(),
            socioRepositoryImpl = get(),
            complementoRepository = get(),
            butacasRepository = get(),
            ventasSotrageHtml = get()
        )
    }
}