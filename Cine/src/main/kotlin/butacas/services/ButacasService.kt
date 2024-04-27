package butacas.services


import butacas.exceptions.ButacaException
import butacas.models.Butaca
import com.github.michaelbull.result.Result
import java.io.File

interface ButacasService {
    fun getAll(): List<Butaca>
    fun getById(id: String):Butaca
    fun create(butaca: Butaca):Butaca
    fun update(id: String, butaca: Butaca):Butaca
    fun delete(id: String): Butaca
}