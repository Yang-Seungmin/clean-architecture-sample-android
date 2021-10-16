package com.example.cleanarchitecture.ui.explore

import android.os.Bundle
import android.view.View
import com.example.cleanarchitecture.MainActivity
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.base.fragment.DataBindingFragment
import com.example.cleanarchitecture.databinding.FragmentExploreBinding

class ExploreFragment :
    DataBindingFragment<MainActivity, FragmentExploreBinding>(R.layout.fragment_explore) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonFilms.setOnClickListener {
            parentActivity?.navigateTo(R.id.action_exploreFragment_to_filmsFragment)
        }

        binding.buttonPeople.setOnClickListener {
            parentActivity?.navigateTo(R.id.action_exploreFragment_to_peopleFragment)
        }

        binding.buttonPlanets.setOnClickListener {
            parentActivity?.navigateTo(R.id.action_exploreFragment_to_planetsFragment)
        }

        binding.buttonSpecies.setOnClickListener {
            parentActivity?.navigateTo(R.id.action_exploreFragment_to_speciesFragment)
        }

        binding.buttonStarships.setOnClickListener {
            parentActivity?.navigateTo(R.id.action_exploreFragment_to_starshipsFragment)
        }

        binding.buttonVehicles.setOnClickListener {
            parentActivity?.navigateTo(R.id.action_exploreFragment_to_vehiclesFragment)
        }
    }

    override fun onResume() {
        super.onResume()
        parentActivity?.showBackButton(false)
        parentActivity?.supportActionBar?.title = getString(R.string.explore)
    }
}