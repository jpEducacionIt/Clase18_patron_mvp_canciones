package com.example.clase18_patron_mvp_canciones.main

class MainPresenter (
    private val mainView: MainContracts.View,
    private val mainRepository: MainContracts.Model
): MainContracts.Presenter {
/*
    override fun getCanciones() {
        val canciones = mainRepository.downloadCanciones()
        mainView.showCanciones(canciones)
    }

 */

    override fun getCanciones() {
        mainRepository.downloadCanciones({
            listadoCanciones ->
            mainView.showCanciones(listadoCanciones)
        }, {
            errorMsg ->
            mainView.showError(errorMsg)
        })
    }
}