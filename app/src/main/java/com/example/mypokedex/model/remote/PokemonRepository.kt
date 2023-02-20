package com.example.mypokedex.model.remote

import com.example.mypokedex.model.remote.response.Pokemon
import com.example.mypokedex.model.remote.response.PokemonList
import com.example.mypokedex.utils.Resource
import dagger.hilt.android.scopes.ActivityScoped
import retrofit2.Response
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokemonAPI
) {

        suspend fun getPokedex(limit: Int, offset: Int): Response<PokemonList> {
        val response = try {
            api.getPokedex(limit, offset)
        } catch (e: Exception){
//            return Resource.Error("An unknown error occured")
        }
        return api.getPokedex(limit,offset)
    }

    suspend fun getPokemon(pokemonName: String): Response<Pokemon> {
        val response = try {
            api.getPokemon(pokemonName)
        } catch (e: Exception){
//            return Resource.Error("An unknown error occured")
        }
        return api.getPokemon(pokemonName)
    }

}