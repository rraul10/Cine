package butacas.errors

sealed class ButacaErrors(val message: String) {
    class ButacaNotFound(message: String) : ButacaErrors(message)
    class ButacaNotValid(message: String) : ButacaErrors(message)
}