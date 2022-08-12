package com.example.clase18_patron_mvp_canciones

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class CancionesAdapter: ListAdapter<Cancion, CancionesAdapter.ViewHolder>(DiffCallBack) {

    private lateinit var onItemClickListener: ((cancion: Cancion) -> Unit)

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val nombreText : TextView = view.findViewById(R.id.textViewNombre)
        private val autorText: TextView = view.findViewById(R.id.textViewAutor)

        fun bind (cancion: Cancion) {
            nombreText.text = cancion.nombre
            autorText.text = cancion.autor

            view.setOnClickListener {
                if (::onItemClickListener.isInitialized) {
                    onItemClickListener(cancion)
                } else {
                    Log.i("TerremotoAdapter", "Implementar listener Adapter")
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CancionesAdapter.ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CancionesAdapter.ViewHolder, position: Int) {
        val cancion = getItem(position)
        holder.bind(cancion)
    }

    fun setOnItemClickListener(onItemClickListener: (cancion: Cancion) -> Unit) {
        this.onItemClickListener = onItemClickListener
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Cancion>() {
        override fun areItemsTheSame(oldItem: Cancion, newItem: Cancion): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Cancion, newItem: Cancion): Boolean {
            return oldItem == newItem
        }
    }
}
