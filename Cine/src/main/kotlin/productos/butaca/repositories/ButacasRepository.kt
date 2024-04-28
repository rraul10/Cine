package productos.butaca.repositories

import productos.models.Butaca

interface ButacasRepository {

    fun findAll(): List<Butaca>
    fun findById(id: String): Butaca?
    fun save(butaca: Butaca): Butaca
    fun update(id: String, butaca: Butaca): Butaca?
    fun delete(id: String): Butaca?
}