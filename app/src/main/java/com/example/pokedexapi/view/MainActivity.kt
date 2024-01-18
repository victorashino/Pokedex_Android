package com.example.pokedexapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexapi.PokemonRepository
import com.example.pokedexapi.databinding.ActivityMainBinding
import com.example.pokedexapi.domain.Pokemon
import com.example.pokedexapi.domain.PokemonType

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var rvPokemons: RecyclerView

    val viewModel: PokemonViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvPokemons = binding.rvPokemons

        viewModel.pokemons.observe(this, Observer {
            loadRecyclerView(it)
        })
    }

    private fun loadRecyclerView(pokemons: List<Pokemon?>) {
        rvPokemons.layoutManager = LinearLayoutManager(this)
        rvPokemons.adapter = PokemonAdapter(pokemons)
    }
}