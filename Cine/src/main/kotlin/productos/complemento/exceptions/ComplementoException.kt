package productos.complemento.exceptions

sealed class ComplementoException(val mensage:String):Exception(mensage) {
    class TipoNoValido(mensage: String): ComplementoException(mensage)
}