package com.example.ijo_in

import com.example.ijo_in.data.local.AppDatabase
import com.example.ijo_in.data.local.LocalRepository
import com.example.ijo_in.data.local.entity.UserEntity
import com.example.ijo_in.data.remote.RemoteRepository

class AppRepository(private val localRepository: LocalRepository, private val remoteRepository: RemoteRepository) {
    suspend fun insertUser(user: UserEntity) {
        localRepository.insertUser(user)
    }

    suspend fun getUser(email: String, password: String): UserEntity{
        return localRepository.getUser(email, password)
    }

    suspend fun getPlants() = remoteRepository.getPlants()


    suspend fun getMovies() = remoteRepository.getMovies()
}