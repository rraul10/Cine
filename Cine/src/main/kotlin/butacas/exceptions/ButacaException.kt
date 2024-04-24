package butacas.exceptions


sealed class ButacaException(val mensage:String):Exception(mensage) {
    class ButacaNoValida(message:String):ButacaException(message)
    class TipoNoValido(mensage: String): ButacaException(mensage)
    class EstadoNoValido(mensage: String): ButacaException(mensage)
    class ActicidadNoValido(mensage: String): ButacaException(mensage)
    class ButacadNoEncontrada(mensage: String): ButacaException(mensage)
}