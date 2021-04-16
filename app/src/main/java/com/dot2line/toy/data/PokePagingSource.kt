package com.dot2line.toy.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.dot2line.toy.domain.GetPokeListUseCase
import com.dot2line.toy.domain.Result
import com.dot2line.toy.model.Pokemon

class PokePagingSource(
    val getPokeListUseCase: GetPokeListUseCase
) : PagingSource<Int, Pokemon>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        val offset = params.key ?: 0
        return when (val res = getPokeListUseCase(offset)) {
            is Result.Success ->
                LoadResult.Page(
                    data = res.data,
                    prevKey = null,
                    nextKey = res.data.takeIf { it.isNotEmpty() }?.last()?.id
                )
            is Result.Error ->
                LoadResult.Error(res.exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? =
        state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
}