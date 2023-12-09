package com.example.ijo_in.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ijo_in.AppRepository
import com.example.ijo_in.data.remote.response.Data
import com.example.ijo_in.data.remote.response.PlantsResponse
import com.example.ijo_in.data.remote.response.movie.MovieResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel (private val appRepository: AppRepository): ViewModel() {

//    private val getPlant = MutableLiveData<Response<Data>>()
//    val observePlant : LiveData<Response<Data>> = getPlant

    private val getMovie = MutableLiveData<Response<MovieResponse>>()
    val observeMovie : LiveData<Response<MovieResponse>> = getMovie
//
//    fun getPlants() {
//        viewModelScope.launch {
//            try {
//                val result = appRepository.getPlants()
//
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }
//    }

    fun getMovies() {
        viewModelScope.launch {
            try {
                val result = appRepository.getMovies()
                Log.d("viewModel", "getMovies: $result")
                getMovie.postValue(result)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}