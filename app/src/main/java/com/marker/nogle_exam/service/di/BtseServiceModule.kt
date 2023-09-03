package com.marker.nogle_exam.service.di

import com.marker.nogle_exam.service.data.BtseWssServiceImpl
import com.marker.nogle_exam.service.domain.IBtseApiService
import com.marker.nogle_exam.service.domain.IBtseWssService
import okhttp3.OkHttpClient
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val btseApiServiceModule = module {
    singleOf(::provideBtseRetrofit)
    singleOf(::provideBtseApiService)

    singleOf(::provideBtseOkHttpClient)
    singleOf(::provideBtseWssServiceImpl) { bind<IBtseWssService>() }
}

private fun provideBtseApiService(retrofit: Retrofit): IBtseApiService {
    return retrofit.create(IBtseApiService::class.java)
}

private fun provideBtseRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://api.btse.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

private fun provideBtseOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .pingInterval(10, TimeUnit.SECONDS)
        .build()
}

private fun provideBtseWssServiceImpl(okHttpClient: OkHttpClient): BtseWssServiceImpl {
    return BtseWssServiceImpl(okHttpClient)
}