package com.example.ijo_in.data.remote

class RemoteRepository(private val apiService: ApiService) {

    suspend fun getPlants() = apiService.getPlants()


    suspend fun getMovies() = apiService.getMovies()
}