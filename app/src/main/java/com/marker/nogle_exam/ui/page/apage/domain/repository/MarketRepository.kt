package com.marker.nogle_exam.ui.page.apage.domain.repository

import kotlinx.coroutines.flow.Flow

interface MarketRepository {
    suspend fun getSortedSpotNameList(): Flow<List<String>>

    suspend fun getSortedFuturesNameList(): Flow<List<String>>
}