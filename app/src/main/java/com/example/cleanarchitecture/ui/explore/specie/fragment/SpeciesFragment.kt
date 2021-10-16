package com.example.cleanarchitecture.ui.explore.specie.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanarchitecture.MainActivity
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.base.fragment.DataBindingFragment
import com.example.cleanarchitecture.databinding.FragmentSpeciesBinding
import com.example.cleanarchitecture.ui.adapter.LoadingStateAdapter
import com.example.cleanarchitecture.ui.explore.specie.adapter.SpeciesAdapter
import com.example.cleanarchitecture.ui.explore.specie.viewmodel.SpecieViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class SpeciesFragment :
    DataBindingFragment<MainActivity, FragmentSpeciesBinding>(R.layout.fragment_species) {

    private val specieViewModel: SpecieViewModel by viewModels()

    private val speciesAdapter = SpeciesAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initViewModel()
    }

    override fun onResume() {
        super.onResume()
        parentActivity?.showBackButton(true)
        parentActivity?.supportActionBar?.title = getString(R.string.species)
    }

    private fun initView() {
        binding.swipeRefreshLayoutSpecies.setOnRefreshListener { speciesAdapter.refresh() }

        binding.recyclerViewSpecies.apply {
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            layoutManager = LinearLayoutManager(requireContext())
            adapter = speciesAdapter.withLoadStateHeaderAndFooter(
                header = LoadingStateAdapter(speciesAdapter),
                footer = LoadingStateAdapter(speciesAdapter)
            )
        }
    }

    private fun initViewModel() {
        with(specieViewModel) {
            lifecycleScope.launch {
                flowSpecie.collectLatest { pagingData ->
                    withContext(Dispatchers.Main) {
                        binding.swipeRefreshLayoutSpecies.isRefreshing = false
                    }
                    speciesAdapter.submitData(pagingData)
                }
            }
        }
    }

}