package com.example.cleanarchitecture.ui.explore.starship.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanarchitecture.MainActivity
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.base.fragment.DataBindingFragment
import com.example.cleanarchitecture.databinding.FragmentStarshipsBinding
import com.example.cleanarchitecture.ui.adapter.LoadingStateAdapter
import com.example.cleanarchitecture.ui.explore.starship.adapter.StarshipsAdapter
import com.example.cleanarchitecture.ui.explore.starship.viewmodel.StarshipViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class StarshipsFragment :
    DataBindingFragment<MainActivity, FragmentStarshipsBinding>(R.layout.fragment_starships) {

    private val starshipViewModel: StarshipViewModel by viewModels()

    private val starshipsAdapter = StarshipsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initViewModel()
    }

    override fun onResume() {
        super.onResume()
        parentActivity?.showBackButton(true)
        parentActivity?.supportActionBar?.title = getString(R.string.starships)
    }

    private fun initView() {
        binding.swipeRefreshLayoutStarships.setOnRefreshListener { starshipsAdapter.refresh() }

        binding.recyclerViewStarships.apply {
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            layoutManager = LinearLayoutManager(requireContext())
            adapter = starshipsAdapter.withLoadStateHeaderAndFooter(
                header = LoadingStateAdapter(starshipsAdapter),
                footer = LoadingStateAdapter(starshipsAdapter)
            )
        }
    }

    private fun initViewModel() {
        with(starshipViewModel) {
            lifecycleScope.launch {
                flowStarship.collectLatest { pagingData ->
                    withContext(Dispatchers.Main) {
                        binding.swipeRefreshLayoutStarships.isRefreshing = false
                    }
                    starshipsAdapter.submitData(pagingData)
                }
            }
        }
    }

}