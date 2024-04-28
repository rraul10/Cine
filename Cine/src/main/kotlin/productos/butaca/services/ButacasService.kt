package productos.butaca.services


import productos.models.Butaca
import java.io.File

interface ButacasService {
    fun getAll(): List<Butaca>
    fun getById(id: String): Butaca
    fun create(butaca: Butaca): Butaca
    fun update(id: String, butaca: Butaca): Butaca
    fun delete(id: String): Butaca
    fun import(csvFile: File): List<Butaca>
    fun export(fecha:String,listaButacas: List<Butaca>)
}