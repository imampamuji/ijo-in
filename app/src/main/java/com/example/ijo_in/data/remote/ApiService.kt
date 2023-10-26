package com.example.ijo_in.data.remote

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/users")
    fun getUsers(): Call<List<UsersItem>>
}