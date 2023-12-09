package com.example.ijo_in.ui.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ijo_in.AppRepository
import com.example.ijo_in.data.local.entity.UserEntity
import kotlinx.coroutines.launch

class LoginViewModel(private val appRepository: AppRepository): ViewModel(){

    private val isLogin = MutableLiveData<UserEntity>()
    fun observeIsLogin(): LiveData<UserEntity?> = isLogin

    private val errorMessage = MutableLiveData<String>()
    fun observeErrorMessage(): LiveData<String> = errorMessage

    fun getDataLogin(email: String, password: String) {
        viewModelScope.launch {
            when (val result = appRepository.getUser(email, password)) {
                is UserEntity -> {
                    isLogin.postValue(result)
                }

            }
        }
    }
//
//    fun getDataLogin(email: String, password: String) {
//        viewModelScope.launch {
//            try {
//                val result = appRepository.getUser(email, password)
//                isLogin.postValue(result)
//            } catch (e: Exception) {
//                errorMessage.postValue("Login failed. Please check your credentials.")
//            }
//        }
//    }
}
