package com.dot2line.toy.model

data class PokeResponse(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<Pokemon>
)