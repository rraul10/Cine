package socio.errors

sealed class SocioError (val message: String){
    class SocioNoValido(message: String):SocioError(message)
    class SocioNombreNoValido(message: String):SocioError(message)
}