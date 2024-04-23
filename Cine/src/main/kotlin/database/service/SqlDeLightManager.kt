package database.service

import butacas.models.Butaca
import socio.models.Socio

fun initDemoButacas() = listOf(
    Butaca(id = 1, estado = "ACTIVA", actividad = "ACTIVA", tipo = ""),
    Butaca(id = 2, estado = "ACTIVA", actividad = "ACTIVA", tipo = ""),
    Butaca(id = 3, estado = "ACTIVA", actividad = "ACTIVA", tipo = ""),
    Butaca(id = 4, estado = "ACTIVA", actividad = "ACTIVA", tipo = ""),
    Butaca(id = 5, estado = "ACTIVA", actividad = "ACTIVA", tipo = ""),
    Butaca(id = 6, estado = "ACTIVA", actividad = "ACTIVA", tipo = ""),
    Butaca(id = 7, estado = "ACTIVA", actividad = "ACTIVA", tipo = ""),
    Butaca(id = 8, estado = "ACTIVA", actividad = "ACTIVA", tipo = ""),
    Butaca(id = 9, estado = "ACTIVA", actividad = "ACTIVA", tipo = ""),
    Butaca(id = 10, estado = "ACTIVA", actividad = "ACTIVA", tipo = ""),
)

fun initDemoSocio() = listOf(
    Socio(
        id = 1,
        nombre = "Samuel Cortes",
        gmail = "samuelcortes@email.com"
    )
)