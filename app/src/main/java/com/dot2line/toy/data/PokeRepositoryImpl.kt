package com.dot2line.toy.data

import com.dot2line.toy.domain.PokeRepository
import com.dot2line.toy.model.PokeResponse
import com.dot2line.toy.network.PokeService


class PokeRepositoryImpl(private val pokeService: PokeService) : PokeRepository {

    override suspend fun getImages(offset: Int): PokeResponse =
        pokeService.getImages(PER_PAGE, offset)

    companion object {
        const val PER_PAGE = 50
    }
}
