package com.example.cleanarchitecture.ui.explore.film.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.databinding.ItemFilmBinding
import com.example.domain.data.film.Film

class FilmsAdapter : PagingDataAdapter<Film, FilmsAdapter.ViewHolder>(
    diffItemCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_film,
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

    class ViewHolder(private val binding: ItemFilmBinding) : RecyclerView.ViewHolder(binding.root) {
        operator fun invoke(film: Film) {
            binding.film = film
            binding.executePendingBindings()
        }
    }

    companion object {
        private val diffItemCallback = object : DiffUtil.ItemCallback<Film>() {
            override fun areItemsTheSame(oldItem: Film, newItem: Film): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Film, newItem: Film): Boolean {
                return oldItem == newItem
            }
        }
    }
}