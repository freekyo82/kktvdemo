package com.example.kktvdemo.di


import com.example.kktvdemo.com.example.kktvdemo.api.SearchApi
import com.example.kktvdemo.com.example.kktvdemo.home.PagingDataSource
import org.koin.dsl.module
import retrofit2.Retrofit


object ApiModule {
    val apiModule = module {
        single { get<Retrofit>().create(SearchApi::class.java) }
        factory { PagingDataSource(get()) }
    }
}