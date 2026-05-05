package com.pf.turismoandalucia

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pf.turismoandalucia.data.Place
import com.pf.turismoandalucia.databinding.ViewPlaceItemBinding

class PlaceAdapter(private val onItemClicked: (Place) -> Unit) :
    ListAdapter<Place, PlaceAdapter.PlaceViewHolder>(DiffCallback) {

    class PlaceViewHolder(private val binding: ViewPlaceItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(place: Place) {
            binding.tvItemName.text = place.name
            binding.tvItemProvince.text = place.province
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val binding = ViewPlaceItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewHolder = PlaceViewHolder(binding)
        binding.root.setOnClickListener {
            val position = viewHolder.adapterPosition
            if (position != RecyclerView.NO_POSITION) onItemClicked(getItem(position))
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Place>() {
            override fun areItemsTheSame(oldItem: Place, newItem: Place): Boolean = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Place, newItem: Place): Boolean = oldItem == newItem
        }
    }
}