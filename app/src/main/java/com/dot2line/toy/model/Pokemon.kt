package com.dot2line.toy.model

data class Pokemon(
    val name: String,
    val url: String
) {
    val imageUrl: String
        get() {
            val index = String.format("%03d", url.split("/".toRegex()).dropLast(1).last().toInt())
            return "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/$index.png"
        }
}