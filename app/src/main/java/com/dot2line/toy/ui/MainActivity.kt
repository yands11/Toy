package com.dot2line.toy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.dot2line.toy.R
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val pokeViewModel: PokeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pokeViewModel.pokeList.observe(this, { pokemons ->
            Timber.d(pokemons.toString())
        })
        pokeViewModel.loadPokeList(0)
    }
}
