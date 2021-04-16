package com.dot2line.toy.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.dot2line.toy.databinding.HolderPokemonBinding
import com.dot2line.toy.ui.model.PokemonUiModel

class PokeAdapter : ListAdapter<PokemonUiModel, PokemonViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder =
        PokemonViewHolder(
            HolderPokemonBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<PokemonUiModel>() {
            override fun areItemsTheSame(
                oldItem: PokemonUiModel,
                newItem: PokemonUiModel
            ): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: PokemonUiModel,
                newItem: PokemonUiModel
            ): Boolean = oldItem == newItem
        }
    }
}