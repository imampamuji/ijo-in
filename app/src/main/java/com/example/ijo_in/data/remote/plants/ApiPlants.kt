package com.example.ijo_in.data.remote.plants

import com.example.ijo_in.data.remote.plants.dto.PlantDetailResponseDto
import com.example.ijo_in.data.remote.plants.dto.PlantsSearchDto
import com.example.ijo_in.utils.Constant.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiPlants {

    @GET("plants/search")
    suspend fun byQ(@Query("q") searchQ: String?,
                    @Query("page") page: Int = 0,
                    @Query("token") token: String = API_KEY
    ): Response<PlantsSearchDto>

    @GET("plants")
    suspend fun byFilter(
        @QueryMap filters: Map<String, String>,
        @Query("page") page: Int = 0,
        @Query("token") token: String = API_KEY
    ): Response<PlantsSearchDto>
    @GET("plants")
    suspend fun default(
        @Query("page") page: Int = 0,
        @Query("token") token: String = API_KEY
    ): Response<PlantsSearchDto>

    @GET("plants/{plantId}")
    suspend fun byId(@Path("plantId") plantId: Int,
                     @Query("token") token: String = API_KEY
    ): Response<PlantDetailResponseDto>
}