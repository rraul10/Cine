package config

import org.lighthousegames.logging.logging
import java.nio.file.Files
import kotlin.io.path.Path

private val logger = logging()

class Config(
    _databaseUrl: String = "jdbc:sqlite:cine.db",
    _databaseInitTables: String = "true",
    _databaseInitData: String = "true",
    _databaseInMemory: String = "true",
    _storageData: String = "data",
) {
    val databaseUrl: String = _databaseUrl
    val databaseInitTables: Boolean = _databaseInitTables.toBoolean()
    val databaseInitData: Boolean = _databaseInitData.toBoolean()
    val databaseInMemory: Boolean = _databaseInMemory.toBoolean()
    val storageData: String = _storageData

    init {
        try {
            logger.debug { "Cargando configuración" }
            Files.createDirectories(Path(storageData))

        } catch (e: Exception) {
            logger.error { "Error cargando configuración: ${e.message}" }
        }

    }
}