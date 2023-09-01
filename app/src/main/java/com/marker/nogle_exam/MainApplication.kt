package com.marker.nogle_exam

import android.app.Application
import com.marker.nogle_exam.service.di.btseApiServiceModule
import com.marker.nogle_exam.ui.page.apage.di.APageModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin


class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(btseApiServiceModule)
            modules(APageModule)
        }
    }
}