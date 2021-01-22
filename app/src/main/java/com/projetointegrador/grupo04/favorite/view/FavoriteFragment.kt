package com.projetointegrador.grupo04.favorite.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.projetointegrador.grupo04.db.AppDatabase
import com.projetointegrador.grupo04.R
import com.projetointegrador.grupo04.favorite.repository.FavoriteRepository
import com.projetointegrador.grupo04.favorite.viewmodel.FavoriteViewModel

class FavoriteFragment : Fragment() {

    private lateinit var _view: View
    private lateinit var _viewModel: FavoriteViewModel
    private lateinit var _adapter: FavoriteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tarefa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _view = view
        _viewModel = ViewModelProvider(
            this,
            FavoriteViewModel
                .TarefaViewModelFactory(FavoriteRepository(AppDatabase.getDatabase(_view.context).favoriteDao()))
        ).get(FavoriteViewModel::class.java)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val manager = GridLayoutManager(_view.context,3)

        _adapter = FavoriteAdapter()

        recyclerView.apply {
            setHasFixedSize(true)

            layoutManager = manager
            adapter = _adapter
        }

        initialize()
    }

    private fun initialize() {
        _viewModel.obterTarefas().observe(viewLifecycleOwner, {
            _adapter.adicionarTarefas(it)
        })
    }
}