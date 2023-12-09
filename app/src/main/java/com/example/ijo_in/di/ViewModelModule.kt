package com.example.ijo_in.di

import com.example.ijo_in.ui.home.HomeViewModel
import com.example.ijo_in.ui.login.LoginViewModel
import com.example.ijo_in.ui.register.RegisterViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { LoginViewModel(get()) }
    single { RegisterViewModel(get()) }
    single { HomeViewModel(get()) }
}