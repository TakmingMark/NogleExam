package com.marker.nogle_exam.service.di

import com.marker.nogle_exam.service.IBtseApiService
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val btseApiServiceModule = module {
    singleOf(::provideBtseRetrofit)
    singleOf(::prvideBtseApiService)
}

fun prvideBtseApiService(retrofit: Retrofit): IBtseApiService {
    return retrofit.create(IBtseApiService::class.java)
}

fun provideBtseRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://api.btse.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}