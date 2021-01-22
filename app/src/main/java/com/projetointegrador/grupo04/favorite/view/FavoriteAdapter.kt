package com.projetointegrador.grupo04.favorite.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.projetointegrador.grupo04.R
import com.projetointegrador.grupo04.favorite.entity.FavoriteEntity

class FavoriteAdapter: RecyclerView.Adapter<FavoriteViewHolder>() {
    private val _favorites: MutableList<FavoriteEntity> = mutableListOf()

    fun adicionarTarefa(favorite: FavoriteEntity) {
        _favorites.add(favorite)
        notifyDataSetChanged()
    }

    fun adicionarTarefas(favorites: List<FavoriteEntity>) {
        _favorites.addAll(favorites)
        notifyDataSetChanged()
    }

    fun atualizar(favoriteEntity: FavoriteEntity) {
        for (tarefa in _favorites) {
            if (tarefa.id == favoriteEntity.id) {
                tarefa.descricao = favoriteEntity.descricao
                break
            }
        }

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.example_series_movies, parent, false)
        return FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val item = _favorites[position]
        holder.bind(item)
    }

    override fun getItemCount() = _favorites.size
}