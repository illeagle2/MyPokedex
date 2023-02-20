package com.example.mypokedex.model.remote.response


import com.google.gson.annotations.SerializedName

data class GenerationIv(
    @SerializedName("diamond-pearl")
    val diamondPearl: DiamondPearl? = DiamondPearl(),
    @SerializedName("heartgold-soulsilver")
    val heartgoldSoulsilver: HeartgoldSoulsilver? = HeartgoldSoulsilver(),
    @SerializedName("platinum")
    val platinum: Platinum? = Platinum()
)