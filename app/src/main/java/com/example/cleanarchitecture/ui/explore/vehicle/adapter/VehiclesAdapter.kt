package com.example.cleanarchitecture.ui.explore.vehicle.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.databinding.ItemVehicleBinding
import com.example.domain.data.vehicle.Vehicle

class VehiclesAdapter : PagingDataAdapter<Vehicle, VehiclesAdapter.ViewHolder>(
    diffItemCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_vehicle,
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

    class ViewHolder(private val binding: ItemVehicleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        operator fun invoke(vehicle: Vehicle) {
            binding.vehicle = vehicle
            binding.executePendingBindings()
        }
    }

    companion object {
        private val diffItemCallback = object : DiffUtil.ItemCallback<Vehicle>() {
            override fun areItemsTheSame(oldItem: Vehicle, newItem: Vehicle): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Vehicle, newItem: Vehicle): Boolean {
                return oldItem == newItem
            }
        }
    }
}