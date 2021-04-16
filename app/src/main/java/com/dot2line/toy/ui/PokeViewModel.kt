package com.dot2line.toy.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.map
import com.dot2line.toy.data.PokePagingSource
import com.dot2line.toy.domain.GetPokeListUseCase
import com.dot2line.toy.ui.model.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class PokeViewModel @Inject constructor(
    private val getPokeListUseCase: GetPokeListUseCase
) : ViewModel() {

    val pokeUiModels = Pager(PagingConfig(pageSize = 20)) {
        PokePagingSource(getPokeListUseCase)
    }.flow.map { pagingData ->
        pagingData.map { it.toUiModel() }
    }.cachedIn(viewModelScope)

}