package com.marker.nogle_exam.ui.page.apage.domain.repository

import kotlinx.coroutines.flow.Flow

interface FuturesRepository {
    suspend fun getFilterPrices(filterType: Int): Flow<List<Double>>
}