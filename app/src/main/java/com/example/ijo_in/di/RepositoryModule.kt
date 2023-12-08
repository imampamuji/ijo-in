package com.example.ijo_in.di

import com.example.ijo_in.AppRepository
import com.example.ijo_in.data.local.LocalRepository
import com.example.ijo_in.data.remote.RemoteRepository
import org.koin.dsl.module


val repositoryModule = module {
    single { LocalRepository(get()) }
    single { RemoteRepository(get()) }
    single { AppRepository (get(), get()) }
}