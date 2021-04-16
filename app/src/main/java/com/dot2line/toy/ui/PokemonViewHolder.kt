package com.dot2line.toy.ui

import androidx.recyclerview.widget.RecyclerView
import com.dot2line.toy.databinding.HolderPokemonBinding
import com.dot2line.toy.ui.model.PokemonUiModel

class PokemonViewHolder(
    private val binding: HolderPokemonBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(pokemonUiModel: PokemonUiModel) = with(pokemonUiModel) {
        binding.tvName.text = name
//        binding.ivProfile
    }
}