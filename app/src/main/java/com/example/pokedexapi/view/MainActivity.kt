package com.example.pokedexapi.view

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexapi.databinding.ActivityMainBinding
import com.example.pokedexapi.domain.Pokemon
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var rvPokemons: RecyclerView

    private val viewModel: PokemonViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvPokemons = binding.rvPokemons

        setRecyclerViewLayoutManager(resources.configuration.orientation)

        viewModel.pokemons.observe(this, Observer {
            loadRecyclerView(it)
        })
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        setRecyclerViewLayoutManager(newConfig.orientation)
    }

    private fun loadRecyclerView(pokemons: List<Pokemon?>) {
        rvPokemons.adapter = PokemonAdapter(pokemons)
    }

    private fun setRecyclerViewLayoutManager(orientation: Int) {
        val columns = if (orientation == Configuration.ORIENTATION_PORTRAIT) 2 else 4
        rvPokemons.layoutManager = GridLayoutManager(this, columns)
    }

}