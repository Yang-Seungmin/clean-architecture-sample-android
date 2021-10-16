package com.example.cleanarchitecture.ui.explore.planet.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.databinding.ItemPlanetBinding
import com.example.domain.data.planet.Planet

class PlanetsAdapter : PagingDataAdapter<Planet, PlanetsAdapter.ViewHolder>(
    diffItemCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_planet,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        if (item != null) {
            holder(item)
        }
    }

    class ViewHolder(private val binding: ItemPlanetBinding) :
        RecyclerView.ViewHolder(binding.root) {
        operator fun invoke(person: Planet) {
            binding.planet = person
            binding.executePendingBindings()
        }
    }

    companion object {
        private val diffItemCallback = object : DiffUtil.ItemCallback<Planet>() {
            override fun areItemsTheSame(oldItem: Planet, newItem: Planet): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Planet, newItem: Planet): Boolean {
                return oldItem == newItem
            }
        }
    }
}