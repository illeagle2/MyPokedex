package com.example.mypokedex.model.remote.response


import com.google.gson.annotations.SerializedName

data class Other(
    @SerializedName("dream_world")
    val dreamWorld: DreamWorld? = DreamWorld(),
    @SerializedName("home")
    val home: Home? = Home(),
    @SerializedName("official-artwork")
    val officialArtwork: OfficialArtwork? = OfficialArtwork()
)