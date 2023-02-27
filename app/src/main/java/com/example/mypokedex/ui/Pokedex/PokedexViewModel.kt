package com.example.mypokedex.ui.Pokedex

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mypokedex.model.local.PokedexListEntry
import com.example.mypokedex.model.remote.PokemonRepository
import com.example.mypokedex.model.remote.response.Pokemon
import com.example.mypokedex.model.remote.response.PokemonList
import com.example.mypokedex.utils.PAGE_SIZE
import com.example.mypokedex.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokedexViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {


    private var currentPage = 0

    private val _pokedexList = MutableLiveData<Resource<PokemonList>>()
    val pokedexList: LiveData<Resource<PokemonList>> = _pokedexList

    private val _pokemon = MutableLiveData<Resource<Pokemon>>()
    val pokemon: LiveData<Resource<Pokemon>> = _pokemon

    var loadError = ""
    var isLoading = false
    var endReached = false


    fun loadPokemonPage(){
        viewModelScope.launch {
            isLoading = true
            val result = repository.getPokedex(PAGE_SIZE, currentPage * PAGE_SIZE)
            if (result.isSuccessful){
                endReached = currentPage * PAGE_SIZE >= result.body()?.count!!
                val pokedexEntries = result.body()!!.results.mapIndexed { index, result ->
                    val number = if(result.url?.endsWith("/")!!) {
                        result.url.dropLast(1).takeLastWhile { it.isDigit() }
                    } else {
                        result.url.takeLastWhile { it.isDigit() }
                    }
                    val url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${number}.png"
                    PokedexListEntry(result.name!!, url, number.toInt() )
                }
                currentPage++
                isLoading = false
                //_pokedexList2.value = _pokedexList2.value?.plus(pokedexEntries)
            } else {
                //_pokedexList.value = Resource.Error(result.message())
            }
        }
    }

    fun getPokedexList(){
        viewModelScope.launch {
            _pokedexList.value = Resource.Loading()
            //_pokedexList.postValue(Resource.Loading())
            val result = repository.getPokedex(20,0)

            if (result.isSuccessful){
                _pokedexList.value = Resource.Success(result.body()!!)
            } else {
                _pokedexList.value = Resource.Error(result.message())
            }

        }
    }

    fun getPokemon(id: String){
            viewModelScope.launch {
                _pokemon.value = Resource.Loading()
                val result = repository.getPokemon(id)

                if (result.isSuccessful) {
                    _pokemon.value = Resource.Success(result.body()!!)
                } else {
                    _pokemon.value = Resource.Error(result.message())
                }
            }
    }

    fun getPokemonSprite(pokemonName: String) {

    }
}

