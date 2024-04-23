package socio.dto

data class ClienteDto(
    val id: String,
    val nombre: String,
    val gmail: String,
    val createdAt: String,
    val updatedAt: String,
    val isDeleted: Boolean = false
)