package com.example.ijo_in

import com.example.ijo_in.data.local.AppDatabase
import com.example.ijo_in.data.local.UserEntity

class AppRepository(private val appDatabase: AppDatabase) {
    suspend fun insertUser(user: UserEntity) {
        appDatabase.userDao().insertUser(user)
    }
}