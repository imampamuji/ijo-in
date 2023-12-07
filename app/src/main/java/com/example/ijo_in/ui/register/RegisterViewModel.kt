package com.example.ijo_in.ui.register

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.ijo_in.AppRepository
import com.example.ijo_in.data.local.AppDatabase
import com.example.ijo_in.data.local.UserEntity

class RegisterViewModel(application: Application): AndroidViewModel(application){

    private val appRepository: AppRepository
    private val appDatabase: AppDatabase

    init {
        appDatabase = AppDatabase.getInstance(application)!!
        appRepository = AppRepository(appDatabase)
    }

    suspend fun insertUser(entity: UserEntity){
        appRepository.insertUser(entity)
    }
}