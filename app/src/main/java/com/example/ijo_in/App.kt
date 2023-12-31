package com.example.ijo_in

import android.app.Application
import com.example.ijo_in.di.networkModule
import com.example.ijo_in.di.repositoryModule
import com.example.ijo_in.di.roomModule
import com.example.ijo_in.di.viewModelModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger(if(BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@App)
            modules( listOf(
                networkModule,
                repositoryModule,
                roomModule,
                viewModelModule
            ))
        }
    }
}