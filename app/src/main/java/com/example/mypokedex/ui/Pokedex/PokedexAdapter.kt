package com.example.mypokedex.ui.Pokedex

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mypokedex.R
import com.example.mypokedex.databinding.ItemPokedexBinding
import com.example.mypokedex.model.remote.PokemonAPI
import com.example.mypokedex.model.remote.PokemonRepository
import com.example.mypokedex.model.remote.response.Pokemon
import com.example.mypokedex.model.remote.response.Result
import kotlin.coroutines.coroutineContext

class PokedexAdapter(
    val data: List<Result>,
): RecyclerView.Adapter<PokedexAdapter.ViewHolder>() {

    //private val repository =  PokemonRepository(PokemonAPI)

    inner class ViewHolder(val view: ItemPokedexBinding): RecyclerView.ViewHolder(view.root) {

        fun initUI(pokemon: Result) {

            view.tvName.text = "${pokemon.name}"
            itemView.setOnClickListener {
                Toast.makeText(itemView.context, "${pokemon.name} was clicked!", Toast.LENGTH_SHORT).show() }

            // second api call to get the sprite?
            with(itemView) {
                Glide.with(context)
                    .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${adapterPosition + 1}.png")
                    .placeholder(R.drawable.animate_loading)
                    .centerCrop()
                    .override(300,300)
                    .into(view.ivSprite)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemPokedexBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.initUI(data[position])
    }
}