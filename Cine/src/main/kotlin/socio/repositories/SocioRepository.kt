package socio.repositories

import socio.models.Socio

interface SocioRepository {
    fun findAll(): List<Socio>
    fun findById(id: Long): Socio?
    fun save(cliente: Socio): Socio
    fun update(id: Long, socio: Socio): Socio?
    fun delete(id: Long): Socio?
}