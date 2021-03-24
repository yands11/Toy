package com.dot2line.toy.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dot2line.toy.domain.GetPokeListUseCase
import com.dot2line.toy.domain.Result
import com.dot2line.toy.ui.model.PokemonUiModel
import com.dot2line.toy.ui.model.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class PokeViewModel @Inject constructor(
    private val getPokeListUseCase: GetPokeListUseCase
) : ViewModel() {

    private val _pokeList = MutableLiveData<List<PokemonUiModel>>()
    val pokeList: LiveData<List<PokemonUiModel>> get() = _pokeList

    fun loadPokeList(beforeId: Int) {
        viewModelScope.launch {
            when (val result = getPokeListUseCase(beforeId)) {
                is Result.Success ->
                    result.data.map { it.toUiModel() }.let(_pokeList::setValue)
                is Result.Error ->
                    result.exception.let(Timber::e)
            }
        }
    }
}