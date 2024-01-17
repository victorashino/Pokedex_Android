package com.example.pokedexapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedexapi.R
import com.example.pokedexapi.databinding.ActivityMainBinding
import com.example.pokedexapi.domain.Pokemon
import com.example.pokedexapi.domain.PokemonType

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rvPokemons = binding.rvPokemons

        val charmander = Pokemon(
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png",
            4,
            "Charmander",
            listOf(
                PokemonType("Fire")
            )
        )
        val pokemons = listOf(
            charmander,
            charmander,
            charmander,
            charmander,
            charmander,
        )

        val layoutManager = LinearLayoutManager(this)
        rvPokemons.layoutManager = layoutManager
        rvPokemons.adapter = PokemonAdapter(pokemons)

    }
}