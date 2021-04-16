package com.dot2line.toy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import com.dot2line.toy.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val decoration by lazy {
        DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
    }
    private val adapter by lazy { PokeAdapter() }
    private val pokeViewModel: PokeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        bindData()
    }

    private fun initView() {
        binding.rvPokemon.run {
            addItemDecoration(decoration)
            adapter = this@MainActivity.adapter
        }
    }

    private fun bindData() {
        lifecycleScope.launch {
            pokeViewModel.pokeUiModels.collectLatest(adapter::submitData)
        }
    }
}
