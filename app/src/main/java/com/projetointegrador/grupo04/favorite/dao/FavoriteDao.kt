package com.projetointegrador.grupo04.favorite.dao

import androidx.room.*
import com.projetointegrador.grupo04.favorite.entity.FavoriteEntity

@Dao
interface FavoriteDao {
    @Insert
    suspend fun inserirTarefa(favorite: FavoriteEntity): Long

    @Query("SELECT * FROM Tarefa")
    suspend fun obterTarefas(): List<FavoriteEntity>

    @Transaction
    @Query("UPDATE Tarefa SET descricao = :descricao Where id = :id")
    fun atualizarTarefa(descricao: String, id: Long)

    @Update @Transaction
    fun atualizarTarefa(favorite: FavoriteEntity)
}