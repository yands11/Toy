package com.dot2line.toy.network

import com.dot2line.toy.model.PokeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeService {
    /**
     * @param limit     item count of list
     * @param offset    load items after offset
     */
    @GET("pokemon")
    suspend fun getImages(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokeResponse
}
