package com.dot2line.toy.ui

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.dot2line.toy.databinding.HolderPokemonBinding
import com.dot2line.toy.ui.model.PokemonUiModel

class PokemonViewHolder(
    private val binding: HolderPokemonBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(pokemonUiModel: PokemonUiModel) = with(pokemonUiModel) {
        binding.tvName.text = "#${id} $name"
        Glide.with(binding.ivProfile)
            .load(imageUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .centerCrop()
            .into(binding.ivProfile)
    }
}