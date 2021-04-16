package com.dot2line.toy.domain

import androidx.annotation.WorkerThread
import com.dot2line.toy.model.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class GetPokeListUseCase(private val pokeRepository: PokeRepository) {

    @WorkerThread
    suspend operator fun invoke(beforeId: Int): Result<List<Pokemon>> =
        withContext(Dispatchers.IO) {
            try {
                val response = pokeRepository.getImages(beforeId)
                Result.Success(response.results)
            } catch (e: Exception) {
                Result.Error(e)
            }
        }

}
