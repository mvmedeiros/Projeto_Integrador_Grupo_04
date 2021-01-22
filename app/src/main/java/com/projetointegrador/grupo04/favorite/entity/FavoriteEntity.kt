package com.projetointegrador.grupo04.favorite.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Tarefa")
data class FavoriteEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    @ColumnInfo
    var descricao: String
)