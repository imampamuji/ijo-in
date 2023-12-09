package com.example.ijo_in.data.remote

import com.example.ijo_in.data.remote.response.movie.MovieResponse
import com.example.ijo_in.data.remote.response.plants.PlantsResponse
import com.example.ijo_in.utils.Constant.API_KEY
import com.example.ijo_in.utils.Constant.API_KEY_PLANTS
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("plants")
    suspend fun getPlants(
        @Query("token") apiKey: String = API_KEY_PLANTS

    ): Response<PlantsResponse>


    @GET("movie/now_playing")
    suspend fun getMovies(
        @Query("api_key")apiKey: String = API_KEY
    ): Response<MovieResponse>
}