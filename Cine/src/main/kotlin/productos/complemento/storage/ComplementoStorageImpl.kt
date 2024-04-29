package org.example.productos.complementos.storage

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import java.io.File
import org.lighthousegames.logging.logging
import productos.complemento.dto.ComplementoDto
import productos.complemento.errors.ComplementoError
import productos.complemento.mappers.toComplemento
import productos.complemento.storage.ComplementoStorage
import productos.models.Complemento

private val logger = logging()

class ComplementoStorageImpl: ComplementoStorage {
    override fun load(file: File): Result<List<Complemento>, ComplementoError> {
        logger.debug { "Carganado complementos desde fichero Csv" }
        return try {
            Ok(file.readLines().drop(1)
                .map {
                    val data = it.split(",")
                    ComplementoDto(
                        nombre = data[0],
                        tipoComplemento = data[1],
                        precio = data[2],
                    ).toComplemento()
                }
            )
        }catch (e: Exception){
            logger.error { "Error al cargar el fichero csv " }
            Err((ComplementoError.FicheroNoValido("Error al leer el fichero csv")))
        }
    }
}