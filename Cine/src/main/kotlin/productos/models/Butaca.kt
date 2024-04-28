package productos.models

const val PROB_VIP = 30
const val PROB_NORMAL = 70

data class Butaca(
    val id : String = "",
    val estado: Estado = Estado.LIBRE,
    val actividad: Actividad = Actividad.ACTIVA,
    val tipo : Tipo = Tipo.NORMAL
):Producto() {
    val precio: Double

    init {
        when(this.tipo){
            Tipo.NORMAL -> precio = 5.0
            Tipo.VIP -> precio = 8.0
        }
    }

    companion object{
        fun random(): Butaca {
            val random = (0..100).random()
            return when {
                random <= PROB_VIP -> Butaca(tipo = Tipo.VIP)
                random <= PROB_NORMAL -> Butaca(tipo = Tipo.NORMAL)
                else -> Butaca()
            }
        }
    }

    override fun toString(): String {
        return "Butaca(Id:$id, Estado:$estado, Actividad:$actividad Tipo: $tipo)"
    }
}

enum class Actividad(val actividad: String){
    ACTIVA("Butaca activa"),
    MANTENIMIENTO("Butaca en mantenimiento"),
    FUERADESERVICIO("Butaca fuera de servicio")
}

enum class Estado(val estado: String){
    LIBRE("Libre"),
    RESERVADA("Reservada"),
    OCUPADA("Ocupada")
}

enum class Tipo(val tipo: String){
    NORMAL("Butaca normal"),
    VIP("Butaca VIP")
}