package butacas.models

class Butaca(
    val id : String,
    val estado: Estado,
    val actividad: String,
    val tipo : Tipo
) {
    val precio: Double

    init {
        when(this.tipo){
            Tipo.NORMAL -> precio = 5.0
            Tipo.VIP -> precio = 8.0
        }
    }
}

enum class Actividad(val actividad: String){
    ACTIVA("Butaca activa")
    MANTENIMIENTO("Butaca en mantenimiento")
    FUERADESERVICIO("Butaca fuera de servicio")
}

enum class Estado(val estado: String){
    LIBRE("Libre")
    RESERVADA("Reservada")
    OCUPADA("Ocupada")
}

enum class Tipo(val tipo: String){
    NORMAL("Butaca normal")
    VIP("Butaca VIP")
}