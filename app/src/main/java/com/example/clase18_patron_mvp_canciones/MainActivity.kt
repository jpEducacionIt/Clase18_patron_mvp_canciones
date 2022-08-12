package com.example.clase18_patron_mvp_canciones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clase18_patron_mvp_canciones.main.MainContracts
import com.example.clase18_patron_mvp_canciones.main.MainModel
import com.example.clase18_patron_mvp_canciones.main.MainPresenter

class MainActivity : AppCompatActivity(), MainContracts.View{

    private lateinit var recyclerView: RecyclerView
    private lateinit var cancionesAdapter: CancionesAdapter
    private val mainPresenter = MainPresenter(this, MainModel())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerCanciones)
        recyclerView.layoutManager = LinearLayoutManager(this)
        cancionesAdapter = CancionesAdapter()
        recyclerView.adapter = cancionesAdapter

        cancionesAdapter.setOnItemClickListener {
            Toast.makeText(this, it.acordes, Toast.LENGTH_SHORT).show()
        }

        mainPresenter.getCanciones()
    }

    override fun showCanciones(listadoCancion: MutableList<Cancion>) {
        if (Utils.isActivityAlive(this)) {
            cancionesAdapter.submitList(listadoCancion)
        }
    }

    override fun showError(message: String) {
        if (Utils.isActivityAlive(this)) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}