package socio.dto

data class SocioDto(
    val id: Long,
    val nombre: String,
    val gmail: String,
    val createdAt: String,
    val updatedAt: String,
    val isDeleted: Boolean = false
)