package socio.mappers

import Database.SocioEntity
import socio.dto.SocioDto
import socio.models.Socio
import java.time.LocalDateTime

fun SocioEntity.toSocio(): Socio {
    return Socio(
        id = this.id.toLong(),
        nombre = this.nombre,
        gmail = this.gmail,
        createdAt = LocalDateTime.parse(this.createAt),
        updatedAt = LocalDateTime.parse(this.updateAt)
    )
}

fun Socio.toSocioDto(): SocioDto {
    return SocioDto(
        id = this.id,
        nombre = this.nombre,
        gmail = this.gmail,
        createdAt = this.createdAt.toString(),
        updatedAt = this.updatedAt.toString(),
        isDeleted = this.isDeleted
    )
}