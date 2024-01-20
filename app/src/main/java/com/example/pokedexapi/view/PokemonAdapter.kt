package com.example.pokedexapi.view

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedexapi.R
import com.example.pokedexapi.domain.Pokemon
import com.example.pokedexapi.domain.PokemonType

class PokemonAdapter(
    private val items: List<Pokemon?>
) : ListAdapter<Pokemon, PokemonAdapter.ViewHolder>(PokemonAdapter) {

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

    companion object : DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.name == newItem.name &&
                    oldItem.number == newItem.number &&
                    oldItem.imageUrl == newItem.imageUrl
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(item: Pokemon?) = with(itemView) {
            val imagePokemon = findViewById<ImageView>(R.id.image_pokemon)
            val textNumber = findViewById<TextView>(R.id.text_number)
            val textName = findViewById<TextView>(R.id.text_name)
            val textType1 = findViewById<TextView>(R.id.text_type_1)
            val textType2 = findViewById<TextView>(R.id.text_type_2)
            val cardType1 = findViewById<CardView>(R.id.card_type1)
            val cardType2 = findViewById<CardView>(R.id.card_type2)

            item?.let {
                Glide.with(itemView.context)
                    .load(it.imageUrl)
                    .into(imagePokemon)

                textNumber.text = "#${item.formattedNumber}"
                textName.text = item.name.capitalize()
                textType1.text = item.types[0].name.capitalize()

                if (item.types.size > 1) {
                    cardType2.visibility = View.VISIBLE
                    textType2.text = item.types[1].name.capitalize()
                } else {
                    cardType2.visibility = View.GONE
                }
            }
        }
    }
}


