package butacas.services


import butacas.exceptions.ButacaException
import butacas.models.Butaca
import com.github.michaelbull.result.Result
import java.io.File

interface ButacasService {
    fun getAll(): Result<List<Butaca>, ButacaException>
    fun getById(id: String): Result<Butaca, ButacaException>
    fun create(butaca: Butaca): Result<Butaca, ButacaException>
    fun update(id: String, butaca: Butaca): Result<Butaca, ButacaException>
    fun delete(id: String): Result<Butaca, ButacaException>
    fun import(csvFile: File): Result<Unit, ButacaException>
}