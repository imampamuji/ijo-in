package com.example.ijo_in.ui.register

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ijo_in.AppRepository
import com.example.ijo_in.data.local.AppDatabase
import com.example.ijo_in.data.local.entity.UserEntity
import com.example.ijo_in.di.repositoryModule
import kotlinx.coroutines.launch

class RegisterViewModel(private val appRepository: AppRepository): ViewModel(){

    private val isRegister = MutableLiveData<Boolean>()

    fun observeIsRegister(): LiveData<Boolean> = isRegister

    fun insertUser(user: UserEntity) {
        viewModelScope.launch {
            try {
                appRepository.insertUser(user)
                isRegister.postValue(true)
            } catch (e: Throwable){
                e.printStackTrace()
            }
        }
    }
}