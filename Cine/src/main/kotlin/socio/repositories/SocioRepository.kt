package socio.repositories

import socio.models.Socio

interface SocioRepository {
    fun findAll(): List<Socio>
    fun findById(id: String): Socio?
    fun save(socio: Socio): Socio
    fun update(id: String, socio: Socio): Socio?
    fun delete(id: String): Socio?
}