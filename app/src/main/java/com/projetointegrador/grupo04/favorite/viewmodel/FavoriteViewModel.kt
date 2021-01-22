package com.projetointegrador.grupo04.favorite.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.projetointegrador.grupo04.favorite.entity.FavoriteEntity
import com.projetointegrador.grupo04.favorite.repository.FavoriteRepository
import kotlinx.coroutines.Dispatchers

class FavoriteViewModel(private val repository: FavoriteRepository): ViewModel() {

    fun inserirTarefa(descricao: String) = liveData(Dispatchers.IO) {
        val tarefa = FavoriteEntity(0, descricao)
        val newId = repository.inserirTarefa(FavoriteEntity(0, descricao))

        tarefa.id = newId

        emit(tarefa)
    }

    fun obterTarefas() = liveData(Dispatchers.IO) {
        emit(repository.obterTarefas())
    }

    fun atualizarTarefa(id: Long, descricao: String) = liveData(Dispatchers.IO) {
        repository.atualizarTarefa(descricao, id)
        emit(true)
    }

    class TarefaViewModelFactory(private val repository: FavoriteRepository): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return FavoriteViewModel(repository) as T
        }

    }
}