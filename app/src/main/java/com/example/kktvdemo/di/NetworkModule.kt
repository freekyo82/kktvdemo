package com.example.kktvdemo.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object NetworkModule {
    val networkModule = module {
        single {
            OkHttpClient.Builder().build()
        }
        single {
            Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        }
        single {
            Retrofit.Builder()
                .baseUrl("https://api.kkbox.com/")
                .client(get())
                .addConverterFactory(MoshiConverterFactory.create(get())).build()
        }
    }

}