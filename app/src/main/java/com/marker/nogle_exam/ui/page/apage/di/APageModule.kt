package com.marker.nogle_exam.ui.page.apage.di

import com.marker.nogle_exam.ui.page.apage.data.repository.MarketRepositoryImpl
import com.marker.nogle_exam.ui.page.apage.domain.repository.MarketRepository
import com.marker.nogle_exam.ui.page.apage.presentation.spot.viewmodel.SpotViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val APageModule = module {
    viewModelOf(::SpotViewModel)

    singleOf(::MarketRepositoryImpl) { bind<MarketRepository>() }
}