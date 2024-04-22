package cine.models

import butacas.models.Butaca

class Sala(
    val filas: Int = 5,
    val columnas: Int = 7,
    val butacas : List<List<Butaca>> = List(filas) { List(columnas) { Butaca.random() } }
) {
}