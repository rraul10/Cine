package productos.butaca.services


import productos.models.Butaca

interface ButacasService {
    fun getAll(): List<Butaca>
    fun getById(id: String): Butaca
    fun create(butaca: Butaca): Butaca
    fun update(id: String, butaca: Butaca): Butaca
    fun delete(id: String): Butaca
}