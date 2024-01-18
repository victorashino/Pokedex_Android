package com.example.pokedexapi.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokedexapi.PokemonRepository
import com.example.pokedexapi.domain.Pokemon

class PokemonViewModel : ViewModel() {


    var pokemons = MutableLiveData<List<Pokemon?>>()

    init {
        Thread(Runnable {
            loadPokemons()
        }).start()
    }

    fun loadPokemons() {

        val pokemonsApiResult = PokemonRepository.listPokemons()

        pokemonsApiResult?.results?.let {

            pokemons.postValue(it.map { pokemonResult ->
                val number = pokemonResult.url
                    .replace("https://pokeapi.co/api/v2/pokemon/", "")
                    .replace("/", "").toInt()

                val pokemonApiResult = PokemonRepository.getPokemon(number)

                pokemonApiResult?.let {
                    Pokemon(
                        pokemonApiResult.id,
                        pokemonApiResult.name,
                        pokemonApiResult.types.map { type ->
                            type.type
                        }
                    )
                }
            })
        }
    }
}