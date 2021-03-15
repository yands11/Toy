package com.dot2line.toy.domain

import com.dot2line.toy.model.PokeResponse


interface PokeRepository {
    suspend fun getImages(offset: Int): PokeResponse
}
