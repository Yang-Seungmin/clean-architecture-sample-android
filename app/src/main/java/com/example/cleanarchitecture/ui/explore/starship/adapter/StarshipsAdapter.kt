package com.example.cleanarchitecture.ui.explore.starship.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.databinding.ItemStarshipBinding
import com.example.domain.data.starship.Starship

class StarshipsAdapter : PagingDataAdapter<Starship, StarshipsAdapter.ViewHolder>(
    diffItemCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_starship,
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

    class ViewHolder(private val binding: ItemStarshipBinding) :
        RecyclerView.ViewHolder(binding.root) {
        operator fun invoke(starship: Starship) {
            binding.starship = starship
            binding.executePendingBindings()
        }
    }

    companion object {
        private val diffItemCallback = object : DiffUtil.ItemCallback<Starship>() {
            override fun areItemsTheSame(oldItem: Starship, newItem: Starship): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Starship, newItem: Starship): Boolean {
                return oldItem == newItem
            }
        }
    }
}