package com.example.mypokedex.model.remote.response


import com.google.gson.annotations.SerializedName

data class GenerationViii(
    @SerializedName("icons")
    val icons: Icons? = Icons()
)