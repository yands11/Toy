package com.dot2line.toy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dot2line.toy.R
import com.dot2line.toy.domain.GetPokeListUseCase
import com.dot2line.toy.domain.Result
import com.dot2line.toy.model.PokeResponse
import com.dot2line.toy.model.Pokemon
import com.dot2line.toy.network.PokeService
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import retrofit2.Retrofit
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var getPokeListUseCase: GetPokeListUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.Main).launch {
            loadPokeList()
        }
    }

    suspend fun loadPokeList() {
        when (val result = getPokeListUseCase.invoke(1)) {
            is Result.Success -> {
                val first = result.data[0]
                Log.d("d", first.imageUrl)
            }
            is Result.Error -> Unit
        }
    }
}
