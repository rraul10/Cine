package ventas.service

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.andThen
import org.lighthousegames.logging.logging
import productos.butaca.repositories.ButacasRepository
import productos.complemento.repositories.ComplementoRepository
import socio.models.Socio
import socio.repositories.SocioRepositoryImpl
import ventas.error.VentaError
import ventas.models.LineaVenta
import ventas.models.Venta
import ventas.repositories.VentasRepository
import ventas.storage.VentasStorage
import java.io.File
import java.util.*

private val logger = logging()
class VentasServiceImpl(
    private val ventasRepository: VentasRepository,
    private val socioRepositoryImpl: SocioRepositoryImpl,
    private val complementoRepository: ComplementoRepository,
    private val butacasRepository: ButacasRepository,
    private val ventasSotrageHtml: VentasStorage
): VentasService{

    override fun getById(id: UUID): Result<Venta, VentaError> {
        logger.debug { "Obteniendo venta por id: $id" }
        return ventasRepository.findById(id)
            ?. let { Ok(it) }
            ?: Err(VentaError.VentaNoEncontrada("No se ha encontrado la venta con id: $id"))
    }

    override fun create(socio: Socio, lineas: List<LineaVenta>): Result<Venta, VentaError> {
        logger.debug { "Creando venta con Cliente y lineas: $socio, $lineas" }
        return validateCliente(socio)
            .andThen { validateLineas(lineas) }
            .andThen { Ok(ventasRepository.save(Venta(socio = socio, lineas = lineas))) }
    }

    private fun validateCliente(socio: Socio): Result<Socio, VentaError> {
        logger.debug { "Validando cliente: $socio" }
        return socioRepositoryImpl.findById(socio.id)
            ?.let { Ok(it) }
            ?: Err(VentaError.VentaNoValida("Cliente no encontrado con id: ${socio.id}"))
    }

    private fun validateLineas(lineas: List<LineaVenta>): Result<List<LineaVenta>, VentaError> {
        logger.debug { "Validando lineas - Existen Productos: $lineas" }
        lineas.forEach {
            butacasRepository.findById(it.butaca.id)
                ?: return Err(VentaError.VentaNoValida("Producto no encontrado con id: ${it.butaca.id}"))
        }
        lineas.forEach {
            it.complemento1?.let { it1 -> butacasRepository.findById(it1.id) }
                ?: return Err(VentaError.VentaNoEncontrada("Complemento no encontrado con id: ${it.complemento1?.id}"))
        }
        lineas.forEach {
            it.complemento3?.let { it1 -> butacasRepository.findById(it1.id) }
                ?: return Err(VentaError.VentaNoEncontrada("Complemento no encontrado con id: ${it.complemento2?.id}"))
        }
        lineas.forEach {
            it.complemento3?.let { it1 -> butacasRepository.findById(it1.id) }
                ?: return Err(VentaError.VentaNoEncontrada("Complemento no encontrado con id: ${it.complemento3?.id}"))
        }

        logger.debug { "Validando lineas - Cantidad y Stock de productos: $lineas" }
        lineas.forEach {
            if (it.cantidad <= 0) {
                return Err(VentaError.VentaNoValida("La cantidad de productos debe ser mayor que 0"))
            }
        }
        return Ok(lineas)
    }

    override fun create(venta: Venta): Result<Venta, VentaError> {
        logger.debug { "Creando venta: $venta" }
        return validateCliente(venta.socio)
            .andThen { validateLineas(venta.lineas) }
            .andThen { Ok(ventasRepository.save(venta)) }
    }

    override fun exportToHtml(venta: Venta, htmlFile: File): Result<Unit, VentaError> {
        logger.debug { "Exportando venta a ficheo html $htmlFile" }
        return ventasSotrageHtml.export(venta, htmlFile)
    }
}