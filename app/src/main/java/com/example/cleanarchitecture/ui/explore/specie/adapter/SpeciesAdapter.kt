package com.example.cleanarchitecture.ui.explore.specie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.databinding.ItemSpecieBinding
import com.example.domain.data.specie.Specie

class SpeciesAdapter : PagingDataAdapter<Specie, SpeciesAdapter.ViewHolder>(
    diffItemCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_specie,
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

    class ViewHolder(private val binding: ItemSpecieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        operator fun invoke(specie: Specie) {
            binding.specie = specie
            binding.executePendingBindings()
        }
    }

    companion object {
        private val diffItemCallback = object : DiffUtil.ItemCallback<Specie>() {
            override fun areItemsTheSame(oldItem: Specie, newItem: Specie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Specie, newItem: Specie): Boolean {
                return oldItem == newItem
            }
        }
    }
}