package com.marker.nogle_exam.ui.page.apage.domain.repository

import kotlinx.coroutines.flow.Flow

interface MarketRepository {
    suspend fun getSortedSpotPriceNameList(): Flow<List<String>>

    suspend fun getSortedFuturesPriceNameList(): Flow<List<String>>
}