package com.example.ijo_in.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ijo_in.data.remote.response.movie.Result
import com.example.ijo_in.databinding.FragmentHomeBinding
import org.koin.android.ext.android.inject
import org.koin.java.KoinJavaComponent.inject

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by inject()
    private var list: List<Result> = listOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        init()
        observeData()

        return binding.root
    }

    private fun observeData() {
        with(viewModel) {
            observeMovie.observe(requireActivity()) {
                it.let { data ->
                    list = data.body()?.results ?: listOf()
                    Log.d("data home", list.toString())
                    with(binding.rvPlant) {
                        adapter = HomeAdapter(list)
                        layoutManager = LinearLayoutManager(requireActivity())
                    }
                }

            }
        }
    }

    private fun init() {
        viewModel.getMovies()
    }

}

