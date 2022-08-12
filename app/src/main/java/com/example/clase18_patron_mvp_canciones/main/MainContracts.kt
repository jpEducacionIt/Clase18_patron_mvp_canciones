package com.example.clase18_patron_mvp_canciones.main

import com.example.clase18_patron_mvp_canciones.Cancion

interface MainContracts {
    interface View {
        fun showCanciones(listadoCancion: MutableList<Cancion>)
        fun showError(message: String)
    }

    interface Presenter {
        fun getCanciones()
    }
/*
    interface Model {
        fun downloadCanciones() : MutableList<Cancion>
    }

 */

    interface Model {
        fun downloadCanciones(successListener: (MutableList<Cancion>) -> Unit,
                              errorListener: (String) -> Unit)
    }
}
