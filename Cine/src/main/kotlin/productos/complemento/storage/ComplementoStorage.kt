package productos.complemento.storage

import com.github.michaelbull.result.Result
import productos.complemento.errors.ComplementoError
import productos.models.Complemento
import java.io.File

interface ComplementoStorage {
    fun load(file: File): Result<List<Complemento>, ComplementoError>
}