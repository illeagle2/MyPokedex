package com.example.mypokedex.di

import com.example.mypokedex.model.remote.PokemonAPI
import com.example.mypokedex.model.remote.PokemonRepository
import com.example.mypokedex.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesPokemonRepository(
        api: PokemonAPI
    ) = PokemonRepository(api)

    @Provides
    fun providesPokemonApi(): PokemonAPI{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PokemonAPI::class.java)
    }
}