package com.example.cleanarchitecture.ui.explore.person.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanarchitecture.MainActivity
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.base.fragment.DataBindingFragment
import com.example.cleanarchitecture.databinding.FragmentPeopleBinding
import com.example.cleanarchitecture.ui.adapter.LoadingStateAdapter
import com.example.cleanarchitecture.ui.explore.person.adapter.PeopleAdapter
import com.example.cleanarchitecture.ui.explore.person.viewmodel.PeopleViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class PeopleFragment :
    DataBindingFragment<MainActivity, FragmentPeopleBinding>(R.layout.fragment_people) {

    private val peopleViewModel: PeopleViewModel by viewModels()

    private val peopleAdapter = PeopleAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initViewModel()
    }

    override fun onResume() {
        super.onResume()
        parentActivity?.showBackButton(true)
        parentActivity?.supportActionBar?.title = getString(R.string.people)
    }

    private fun initView() {
        binding.swipeRefreshLayoutPeople.setOnRefreshListener { peopleAdapter.refresh() }

        binding.recyclerViewPeople.apply {
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            layoutManager = LinearLayoutManager(requireContext())
            adapter = peopleAdapter.withLoadStateHeaderAndFooter(
                header = LoadingStateAdapter(peopleAdapter),
                footer = LoadingStateAdapter(peopleAdapter)
            )
        }
    }

    private fun initViewModel() {
        with(peopleViewModel) {
            lifecycleScope.launch {
                flowPeople.collectLatest { pagingData ->
                    withContext(Dispatchers.Main) {
                        binding.swipeRefreshLayoutPeople.isRefreshing = false
                    }
                    peopleAdapter.submitData(pagingData)
                }
            }
        }
    }

}