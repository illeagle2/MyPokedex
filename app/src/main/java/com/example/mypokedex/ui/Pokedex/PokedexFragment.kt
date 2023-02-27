package com.example.mypokedex.ui.Pokedex

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mypokedex.databinding.FragmentPokedexBinding
import com.example.mypokedex.model.remote.PokemonAPI
import com.example.mypokedex.model.remote.PokemonRepository
import com.example.mypokedex.model.remote.response.PokemonList
import com.example.mypokedex.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokedexFragment : Fragment() {

    private var _binding: FragmentPokedexBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: PokedexViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPokedexBinding.inflate(inflater, container, false)

        binding.let { ui ->

            viewModel.pokedexList.observe(viewLifecycleOwner) {
                when (it) {
                    is Resource.Loading -> {}
                    is Resource.Success -> {
                        initView(it.data)
                    }
                    is Resource.Error -> {}
                }
            }
            viewModel.getPokedexList()
           //viewModel.loadPokemonPage()
        }

        return binding.root

    }

    private fun initView(data: PokemonList?) {
        data?.let {
            binding.rvPokedex.layoutManager = GridLayoutManager(context, 3)
            binding.rvPokedex.adapter = PokedexAdapter(data.results)
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}