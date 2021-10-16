package com.example.cleanarchitecture.ui.home

import com.example.cleanarchitecture.MainActivity
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.base.fragment.DataBindingFragment
import com.example.cleanarchitecture.databinding.FragmentHomeBinding

class HomeFragment :
    DataBindingFragment<MainActivity, FragmentHomeBinding>(R.layout.fragment_home) {
    override fun onResume() {
        super.onResume()
        parentActivity?.showBackButton(false)
        parentActivity?.supportActionBar?.title = getString(R.string.home)
    }
}