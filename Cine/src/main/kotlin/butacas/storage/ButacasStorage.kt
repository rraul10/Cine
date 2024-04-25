package butacas.storage

import butacas.models.Butaca
import java.io.File

interface ButacasStorage {

    fun import(lista: List<Butaca>)
    fun export(file: File): List<Butaca>
}