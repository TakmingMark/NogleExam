package com.marker.nogle_exam.ui.page.apage.di

import com.marker.nogle_exam.ui.page.apage.AScreenViewModel
import com.marker.nogle_exam.ui.page.apage.data.repository.FuturesRepositoryImpl
import com.marker.nogle_exam.ui.page.apage.data.repository.MarketRepositoryImpl
import com.marker.nogle_exam.ui.page.apage.domain.repository.FuturesRepository
import com.marker.nogle_exam.ui.page.apage.domain.repository.MarketRepository
import com.marker.nogle_exam.ui.page.apage.presentation.futures.viewmodel.FuturesViewModel
import com.marker.nogle_exam.ui.page.apage.presentation.spot.viewmodel.SpotViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val APageModule = module {
    viewModelOf(::AScreenViewModel)
    viewModelOf(::SpotViewModel)
    viewModelOf(::FuturesViewModel)

    singleOf(::MarketRepositoryImpl) { bind<MarketRepository>() }


    singleOf(::FuturesRepositoryImpl) { bind<FuturesRepository>() }
}