package com.example.cleanarchitecture.ui.explore.film.fragment

import android.os.Bundle
import android.view.View
import com.example.cleanarchitecture.MainActivity
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.base.fragment.DataBindingFragment
import com.example.cleanarchitecture.databinding.FragmentFilmDetailBinding

class FilmDetailFragment :
    DataBindingFragment<MainActivity, FragmentFilmDetailBinding>(R.layout.fragment_film_detail) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}