package socio.dto

import kotlinx.serialization.Serializable

@Serializable
data class SocioDto(
    val id: Long,
    val nombre: String,
    val gmail: String,
    val createdAt: String,
    val updatedAt: String,
    val isDeleted: Boolean = false
)