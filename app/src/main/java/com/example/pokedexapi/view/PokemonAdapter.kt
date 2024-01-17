package com.example.pokedexapi.view

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexapi.R
import com.example.pokedexapi.domain.Pokemon

class PokemonAdapter(
    private val items: List<Pokemon>
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.pokemon_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bindView(item)
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Pokemon) = with(itemView) {
            val imagePokemon = findViewById<ImageView>(R.id.image_pokemon)
            val textNumber = findViewById<TextView>(R.id.text_number)
            val textName = findViewById<TextView>(R.id.text_name)
            val textType1 = findViewById<TextView>(R.id.text_type_1)
            val textType2 = findViewById<TextView>(R.id.text_type_2)

            textNumber.text = "N° ${item.formattedNumber}"
            textName.text = item.name
            textType1.text = item.types[0].name

            if (item.types.size > 1) {
                textType2.visibility = View.VISIBLE
                textType2.text = item.types[1].name
            } else {
                textType2.visibility = View.GONE
            }
        }
    }
}


