package productos.butaca.storage

import productos.models.Butaca
import java.io.File

interface ButacasStorage {

    fun save(fecha: String, lista: List<Butaca>)
    fun load(file: File): List<Butaca>
}