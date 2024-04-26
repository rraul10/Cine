package org.example.database

import Database.DatabaseQueries
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import cine.database.AppDatabase
import config.Config
import org.lighthousegames.logging.logging

private val logger = logging()
class SqlDelightManager{
    val databaseQueries: DatabaseQueries by lazy { initQueries() }

    init {
        logger.debug { "Inicializando el gestor de Base de Datos con SqlDelight" }
        initialize()
    }

    private fun initQueries(): DatabaseQueries {

        return if (Config.databaseInMemory) {
            logger.debug { "SqlDeLightClient - InMemory" }
            JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
        } else {
            logger.debug { "SqlDeLightClient - File: ${Config.databaseUrl}" }
            JdbcSqliteDriver(Config.databaseUrl)
        }.let { driver ->
            logger.debug { "Creando Tablas (si es necesario)" }
            AppDatabase.Schema.create(driver)
            AppDatabase(driver)
        }.databaseQueries
    }

    fun initialize() {
        if (Config.databaseInitData) {
            removeAllData()
        }
    }


    private fun removeAllData() {
        logger.debug { "SqlDeLightClient.removeAllData()" }
        databaseQueries.transaction {
            databaseQueries.deleteAllButacaEntity()
        }
    }
}