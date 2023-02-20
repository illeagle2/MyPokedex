package com.example.mypokedex.model.remote.response


import com.google.gson.annotations.SerializedName

data class GenerationI(
    @SerializedName("red-blue")
    val redBlue: RedBlue? = RedBlue(),
    @SerializedName("yellow")
    val yellow: Yellow? = Yellow()
)