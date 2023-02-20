package com.example.mypokedex.model.remote.response


import com.google.gson.annotations.SerializedName

data class GenerationVi(
    @SerializedName("omegaruby-alphasapphire")
    val omegarubyAlphasapphire: OmegarubyAlphasapphire? = OmegarubyAlphasapphire(),
    @SerializedName("x-y")
    val xY: XY? = XY()
)