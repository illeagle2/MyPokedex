package com.example.mypokedex.model.remote.response


import com.google.gson.annotations.SerializedName

data class PokemonList(
    @SerializedName("count")
    val count: Int? = 0,
    @SerializedName("next")
    val next: String? = "",
    @SerializedName("previous")
    val previous: Any? = Any(),
    @SerializedName("results")
    val results: List<Result>
)