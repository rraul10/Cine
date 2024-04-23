package ventas.error

sealed class VentaError(val message: String) {
    class VentasNoEncontradas(message: String) : VentaError(message)
    class VentasNoValidas(message: String) : VentaError(message)
    class VentasNoAlmacenadas(message: String) : VentaError(message)
    class VentasStorageError(message: String) : VentaError(message)
}