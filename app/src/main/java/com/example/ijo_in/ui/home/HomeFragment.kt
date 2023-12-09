package com.example.ijo_in.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ijo_in.data.remote.response.movie.Result
import com.example.ijo_in.data.remote.response.plants.Data
import com.example.ijo_in.databinding.FragmentHomeBinding
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by inject()
    private var listMovie: List<Result> = listOf()

    private var listPlant: List<Data> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

//        initMovie()
//        observeDataMovie()

        initPlant()
        observeDataPlant()

        return binding.root
    }

    private fun observeDataPlant() {
        with(viewModel) {
            observePlant.observe(requireActivity()) {
                it.let { data ->
                    listPlant = data.body()?.data ?: listOf()
                    Log.d("data home", listPlant.toString())
                    with(binding.rvPlant) {
                        adapter = HomeAdapterPlants(listPlant)
                        layoutManager = LinearLayoutManager(requireActivity())
                    }
                }

            }
        }
    }

    private fun initPlant() {
        viewModel.getPlants()
    }

    private fun observeDataMovie() {
        with(viewModel) {
            observeMovie.observe(requireActivity()) {
                it.let { data ->
                    listMovie = data.body()?.results ?: listOf()
                    Log.d("data home", listMovie.toString())
                    with(binding.rvPlant) {
                        adapter = HomeAdapterMovie(listMovie)
                        layoutManager = LinearLayoutManager(requireActivity())
                    }
                }

            }
        }
    }

    private fun initMovie() {
        viewModel.getMovies()
    }

}

