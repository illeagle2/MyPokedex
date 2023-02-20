package com.example.mypokedex.model.remote.response


import com.google.gson.annotations.SerializedName

data class GameIndice(
    @SerializedName("game_index")
    val gameIndex: Int? = 0,
    @SerializedName("version")
    val version: Version? = Version()
)