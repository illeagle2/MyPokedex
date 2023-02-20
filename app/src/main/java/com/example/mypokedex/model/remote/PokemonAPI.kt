package com.example.mypokedex.model.remote

import com.example.mypokedex.model.remote.response.Pokemon
import com.example.mypokedex.model.remote.response.PokemonList
import com.example.mypokedex.utils.END_POKEMON
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonAPI {


    @GET(END_POKEMON)
    suspend fun getPokedex(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonList

    @GET(END_POKEMON+"{name}")
    suspend fun getPokemon(
        @Path("name") name: String
    ): Pokemon

}