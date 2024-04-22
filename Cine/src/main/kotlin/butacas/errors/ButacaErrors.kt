package butacas.errors

sealed class ButacaErrors(val message: String) {
    class ButacaNotValid(message: String) : ButacaErrors(message)
}