package com.example.mypokedex.model.remote.response


import com.google.gson.annotations.SerializedName

data class GenerationV(
    @SerializedName("black-white")
    val blackWhite: BlackWhite? = BlackWhite()
)