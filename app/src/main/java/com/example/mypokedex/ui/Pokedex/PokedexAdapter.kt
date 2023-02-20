package com.example.mypokedex.ui.Pokedex

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mypokedex.R
import com.example.mypokedex.databinding.ItemPokedexBinding
import com.example.mypokedex.model.remote.response.Pokemon
import com.example.mypokedex.model.remote.response.Result

class PokedexAdapter(
    val data: List<Result>
): RecyclerView.Adapter<PokedexAdapter.ViewHolder>() {

    inner class ViewHolder(val view: ItemPokedexBinding): RecyclerView.ViewHolder(view.root){

        fun initUI(pokemon: Result){

            view.tvName.text = "${pokemon.name}"

// second api call to get the sprite?
//            with(itemView) {
//                Glide.with(context)
//                    .load(pokemon.sprites?.frontDefault)
//                    .placeholder(R.drawable.animate_loading)
//                    .centerCrop()
//                    .into(view.ivSprite)
//            }
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