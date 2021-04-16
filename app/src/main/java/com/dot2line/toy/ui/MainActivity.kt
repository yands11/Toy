package com.dot2line.toy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import com.dot2line.toy.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val adapter by lazy { PokeAdapter() }
    private val pokeViewModel: PokeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        bindData()
        loadData()
    }

    private fun initView() {
        binding.rvPokemon.run {
            addItemDecoration(
                DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL)
            )
            adapter = this@MainActivity.adapter
        }
    }

    private fun bindData() {
        pokeViewModel.pokeList.observe(this, adapter::submitList)
    }

    private fun loadData() {
        pokeViewModel.loadPokeList(0)
    }
}
