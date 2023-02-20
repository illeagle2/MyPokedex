package com.example.mypokedex.model.remote.response


import com.google.gson.annotations.SerializedName

data class GenerationIii(
    @SerializedName("emerald")
    val emerald: Emerald? = Emerald(),
    @SerializedName("firered-leafgreen")
    val fireredLeafgreen: FireredLeafgreen? = FireredLeafgreen(),
    @SerializedName("ruby-sapphire")
    val rubySapphire: RubySapphire? = RubySapphire()
)