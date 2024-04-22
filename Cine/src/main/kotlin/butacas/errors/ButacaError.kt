package butacas.errors

sealed class ButacaError(val message: String) {
    class ButacaNotValid(message: String) : ButacaError(message)
}