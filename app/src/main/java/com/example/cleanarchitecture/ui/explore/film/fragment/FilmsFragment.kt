package com.example.cleanarchitecture.ui.explore.film.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanarchitecture.MainActivity
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.base.fragment.DataBindingFragment
import com.example.cleanarchitecture.databinding.FragmentFilmsBinding
import com.example.cleanarchitecture.ui.adapter.LoadingStateAdapter
import com.example.cleanarchitecture.ui.explore.film.adapter.FilmsAdapter
import com.example.cleanarchitecture.ui.explore.film.viewmodel.FilmsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class FilmsFragment :
    DataBindingFragment<MainActivity, FragmentFilmsBinding>(R.layout.fragment_films) {

    private val filmsViewModel: FilmsViewModel by viewModels()

    private val filmsAdapter = FilmsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initViewModel()
    }

    override fun onResume() {
        super.onResume()
        parentActivity?.showBackButton(true)
        parentActivity?.supportActionBar?.title = getString(R.string.films)
    }

    private fun initView() {
        binding.swipeRefreshLayoutFilms.setOnRefreshListener { filmsAdapter.refresh() }

        binding.recyclerViewFilms.apply {
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            layoutManager = LinearLayoutManager(requireContext())
            adapter = filmsAdapter.withLoadStateHeaderAndFooter(
                header = LoadingStateAdapter(filmsAdapter),
                footer = LoadingStateAdapter(filmsAdapter)
            )
        }
    }

    private fun initViewModel() {
        with(filmsViewModel) {
            lifecycleScope.launch {
                flowFilms.collectLatest { pagingData ->
                    withContext(Dispatchers.Main) {
                        binding.swipeRefreshLayoutFilms.isRefreshing = false
                    }
                    filmsAdapter.submitData(pagingData)
                }
            }
        }
    }

}