package com.example.mypokedex.model.remote.response


import com.google.gson.annotations.SerializedName

data class GenerationVii(
    @SerializedName("icons")
    val icons: Icons? = Icons(),
    @SerializedName("ultra-sun-ultra-moon")
    val ultraSunUltraMoon: UltraSunUltraMoon? = UltraSunUltraMoon()
)