package socio.models

import java.time.LocalDateTime

data class Socio(
    val id: Long = -1,
    val nombre: String,
    val gmail: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now(),
    val isDeleted: Boolean = false
)