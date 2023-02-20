package com.example.mypokedex.ui.Pokedex

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mypokedex.model.local.PokedexListEntry
import com.example.mypokedex.model.remote.PokemonRepository
import com.example.mypokedex.model.remote.response.PokemonList
import com.example.mypokedex.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokedexViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {


    private val _pokedexList = MutableLiveData<Resource<PokemonList>>()
    val pokedexList: LiveData<Resource<PokemonList>> = _pokedexList

    fun getPokedexList(){
        viewModelScope.launch {
            _pokedexList.value = Resource.Loading()
            val result = repository.getPokedex(20,0)

            if (result.isSuccessful){
                _pokedexList.value = Resource.Success(result.body()!!)
            } else {
                _pokedexList.value = Resource.Error(result.message())
            }

        }
    }
}

