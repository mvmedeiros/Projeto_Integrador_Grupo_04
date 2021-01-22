package com.projetointegrador.grupo04.favorite.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.projetointegrador.grupo04.R
import com.projetointegrador.grupo04.favorite.entity.FavoriteEntity

class FavoriteViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

    private val descricaoTarefa = view.findViewById<TextView>(R.id.tvMediaName)

    fun bind(favorite: FavoriteEntity) {
        descricaoTarefa.text = favorite.descricao
    }
}