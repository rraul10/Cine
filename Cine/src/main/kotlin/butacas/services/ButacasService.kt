package butacas.services


import butacas.errors.ButacaError
import butacas.models.Butaca
import com.github.michaelbull.result.Result
import java.io.File

interface ButacasService {
    fun getAll(): Result<List<Butaca>, ButacaError>
    fun getById(id: String): Result<Butaca, ButacaError>
    fun create(butaca: Butaca): Result<Butaca, ButacaError>
    fun update(id: String, butaca: Butaca): Result<Butaca, ButacaError>
    fun delete(id: String): Result<Butaca, ButacaError>
    fun import(csvFile: File): Result<Unit, ButacaError>
}