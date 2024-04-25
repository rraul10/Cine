package complementos.models

class Comida(
    val nombre:CategoriaComida
):Complemento(nombre.toString()) {
    val precio:Double
    init {
        when(nombre){
            CategoriaComida.PALOMITAS-> precio=3.0
            CategoriaComida.FRUTOSSECOS->precio=2.0
            CategoriaComida.PATATAS-> precio=2.5
        }
    }
}
enum class CategoriaComida{
    PALOMITAS,
    FRUTOSSECOS,
    PATATAS
}