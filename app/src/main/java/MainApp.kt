package com.example.kktvdemo

import android.app.Application
import com.example.kktvdemo.di.ApiModule.apiModule
import com.example.kktvdemo.di.NetworkModule.networkModule
import com.example.kktvdemo.di.ViewModelModule.viewModelModule

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

open class MainApp : Application() {

    companion object {
        private const val TAG = "MainApp"
    }


    override fun onCreate() {
        super.onCreate()
        starKoinDI()
    }

    private fun starKoinDI() {
        startKoin {
            androidLogger()
            androidContext(this@MainApp)
            modules(apiModule, networkModule, viewModelModule)
        }
    }
}