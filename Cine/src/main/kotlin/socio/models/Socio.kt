package socio.models

data class Socio(
    val id: String,
    val nombre: String,
    val is_deleted: Boolean = false
){

    override fun toString(): String {
        return "Socio(id: $id, nombre: $nombre, isDeleted: $is_deleted)"
    }
}
