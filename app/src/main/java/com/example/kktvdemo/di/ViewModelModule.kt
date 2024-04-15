package com.example.kktvdemo.di


import com.example.kktvdemo.com.example.kktvdemo.home.HomeViewModel
import com.example.kktvdemo.com.example.kktvdemo.home.PagingDataSource
import com.example.kktvdemo.com.example.kktvdemo.home.RemoteRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

object ViewModelModule {

    val viewModelModule = module {
        single<RemoteRepository> { RemoteRepository(get()) }
        viewModel { HomeViewModel(get()) }

    }
}