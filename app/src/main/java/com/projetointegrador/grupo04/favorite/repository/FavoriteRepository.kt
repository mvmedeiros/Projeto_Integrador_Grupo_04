package com.projetointegrador.grupo04.favorite.repository

import com.projetointegrador.grupo04.favorite.dao.FavoriteDao
import com.projetointegrador.grupo04.favorite.entity.FavoriteEntity

class FavoriteRepository(private val favoriteDao: FavoriteDao) {
    suspend fun inserirTarefa(favorite: FavoriteEntity) = favoriteDao.inserirTarefa(favorite)
    suspend fun obterTarefas(): List<FavoriteEntity> = favoriteDao.obterTarefas()
    suspend fun atualizarTarefa(descricao: String, id: Long) = favoriteDao.atualizarTarefa(descricao, id)
}