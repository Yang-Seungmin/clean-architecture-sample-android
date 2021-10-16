package com.example.cleanarchitecture.ui.explore.planet.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanarchitecture.MainActivity
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.base.fragment.DataBindingFragment
import com.example.cleanarchitecture.databinding.FragmentPlanetsBinding
import com.example.cleanarchitecture.ui.adapter.LoadingStateAdapter
import com.example.cleanarchitecture.ui.explore.planet.adapter.PlanetsAdapter
import com.example.cleanarchitecture.ui.explore.planet.viewmodel.PlanetViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class PlanetsFragment :
    DataBindingFragment<MainActivity, FragmentPlanetsBinding>(R.layout.fragment_planets) {

    private val planetViewModel: PlanetViewModel by viewModels()

    private val planetAdapter = PlanetsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initViewModel()
    }

    override fun onResume() {
        super.onResume()
        parentActivity?.showBackButton(true)
        parentActivity?.supportActionBar?.title = getString(R.string.planets)
    }

    private fun initView() {
        binding.swipeRefreshLayoutPlanets.setOnRefreshListener { planetAdapter.refresh() }

        binding.recyclerViewPlanets.apply {
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            layoutManager = LinearLayoutManager(requireContext())
            adapter = planetAdapter.withLoadStateHeaderAndFooter(
                header = LoadingStateAdapter(planetAdapter),
                footer = LoadingStateAdapter(planetAdapter)
            )
        }
    }

    private fun initViewModel() {
        with(planetViewModel) {
            lifecycleScope.launch {
                flowPlanet.collectLatest { pagingData ->
                    withContext(Dispatchers.Main) {
                        binding.swipeRefreshLayoutPlanets.isRefreshing = false
                    }
                    planetAdapter.submitData(pagingData)
                }
            }
        }
    }

}