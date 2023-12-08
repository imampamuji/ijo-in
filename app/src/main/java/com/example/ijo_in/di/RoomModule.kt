package com.example.ijo_in.di

import androidx.room.Room
import com.example.ijo_in.data.local.AppDatabase
import org.koin.dsl.module
import org.koin.android.ext.koin.androidContext

val roomModule = module {
    single {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "db")
            .build()
    }
}