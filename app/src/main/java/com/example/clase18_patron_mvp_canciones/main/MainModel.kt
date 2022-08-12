package com.example.clase18_patron_mvp_canciones.main

import com.example.clase18_patron_mvp_canciones.Cancion

class MainModel: MainContracts.Model {

    /*
    override fun downloadCanciones(): MutableList<Cancion> {
        val listadoCanciones = mutableListOf<Cancion>()

        listadoCanciones.add(Cancion(1, "Jump", "Van halen", "Do re mi fa sol"))
        listadoCanciones.add(Cancion(2, "18 and Life", "Skid Row", "Do re mi fa sol"))
        listadoCanciones.add(Cancion(3, "Symphony of destruction", "Megadeath", "Do re mi fa sol"))
        listadoCanciones.add(Cancion(4, "Paranoid", "Black Sabbath", "Do re mi fa sol"))
        listadoCanciones.add(Cancion(5, "Run to the hills", "iron Maiden", "Do re mi fa sol"))
        listadoCanciones.add(Cancion(6, "Ride the lighting", "Metallica", "Do re mi fa sol"))
        listadoCanciones.add(Cancion(7, "Woman from Tokio", "Deep Purple", "Do re mi fa sol"))
        listadoCanciones.add(Cancion(8, "Welcome to the jungle", "Guns and Roses", "Do re mi fa sol"))

        return listadoCanciones
    }

     */
    override fun downloadCanciones(
        successListener: (MutableList<Cancion>) -> Unit,
        errorListener: (String) -> Unit) {

        val random = 1
        val listadoCanciones = mutableListOf<Cancion>()

        listadoCanciones.add(Cancion(1, "Jump", "Van halen", "Do re mi fa sol"))
        listadoCanciones.add(Cancion(2, "18 and Life", "Skid Row", "Do re mi fa sol"))
        listadoCanciones.add(Cancion(3, "Symphony of destruction", "Megadeath", "Do re mi fa sol"))
        listadoCanciones.add(Cancion(4, "Paranoid", "Black Sabbath", "Do re mi fa sol"))
        listadoCanciones.add(Cancion(5, "Run to the hills", "iron Maiden", "Do re mi fa sol"))
        listadoCanciones.add(Cancion(6, "Ride the lighting", "Metallica", "Do re mi fa sol"))
        listadoCanciones.add(Cancion(7, "Woman from Tokio", "Deep Purple", "Do re mi fa sol"))
        listadoCanciones.add(Cancion(8, "Welcome to the jungle", "Guns and Roses", "Do re mi fa sol"))

        if (random == 1) {
            errorListener("Ha sucedido un error")
        } else {
            successListener(listadoCanciones)
        }
    }
}
