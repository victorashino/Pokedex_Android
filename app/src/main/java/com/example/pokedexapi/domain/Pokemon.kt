package com.example.pokedexapi.domain

data class Pokemon(
    val number: Int,
    val name: String,
    val types: List<PokemonType>
) {
    val formattedNumber = number.toString().padStart(3, '0')
//    val imageUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/${formattedNumber}.png"
//    val imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/showdown/$number.gif"
    val imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/$number.gif"

}