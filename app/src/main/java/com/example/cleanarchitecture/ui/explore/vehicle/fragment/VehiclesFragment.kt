package com.example.cleanarchitecture.ui.explore.vehicle.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanarchitecture.MainActivity
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.base.fragment.DataBindingFragment
import com.example.cleanarchitecture.databinding.FragmentVehiclesBinding
import com.example.cleanarchitecture.ui.adapter.LoadingStateAdapter
import com.example.cleanarchitecture.ui.explore.vehicle.adapter.VehiclesAdapter
import com.example.cleanarchitecture.ui.explore.vehicle.viewmodel.VehicleViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class VehiclesFragment :
    DataBindingFragment<MainActivity, FragmentVehiclesBinding>(R.layout.fragment_vehicles) {

    private val vehicleViewModel: VehicleViewModel by viewModels()

    private val vehiclesAdapter = VehiclesAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initViewModel()
    }

    override fun onResume() {
        super.onResume()
        parentActivity?.showBackButton(true)
        parentActivity?.supportActionBar?.title = getString(R.string.vehicles)
    }

    private fun initView() {
        binding.swipeRefreshLayoutVehicles.setOnRefreshListener { vehiclesAdapter.refresh() }

        binding.recyclerViewVehicles.apply {
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            layoutManager = LinearLayoutManager(requireContext())
            adapter = vehiclesAdapter.withLoadStateHeaderAndFooter(
                header = LoadingStateAdapter(vehiclesAdapter),
                footer = LoadingStateAdapter(vehiclesAdapter)
            )
        }
    }

    private fun initViewModel() {
        with(vehicleViewModel) {
            lifecycleScope.launch {
                flowVehicle.collectLatest { pagingData ->
                    withContext(Dispatchers.Main) {
                        binding.swipeRefreshLayoutVehicles.isRefreshing = false
                    }
                    vehiclesAdapter.submitData(pagingData)
                }
            }
        }
    }

}