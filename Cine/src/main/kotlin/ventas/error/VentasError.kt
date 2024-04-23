package ventas.error

sealed class VentasError(val message: String) {
    class VentasNoEncontradas(message: String) : VentasError(message)
    class VentasNoValidas(message: String) : VentasError(message)
    class VentasNoAlmacenadas(message: String) : VentasError(message)
    class VentasStorageError(message: String) : VentasError(message)
}