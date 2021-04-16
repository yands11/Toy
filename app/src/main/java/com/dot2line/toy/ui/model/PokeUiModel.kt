package com.dot2line.toy.ui.model

import com.dot2line.toy.model.Pokemon

data class PokemonUiModel(
    val id: Int,
    val name: String,
    val imageUrl: String
)

fun Pokemon.toUiModel(): PokemonUiModel =
    PokemonUiModel(
        id = id,
        name = name.capitalize(),
        imageUrl = imageUrl
    )
