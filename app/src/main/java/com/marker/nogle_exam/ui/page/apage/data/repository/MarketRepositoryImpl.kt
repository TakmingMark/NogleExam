package com.marker.nogle_exam.ui.page.apage.data.repository

import com.marker.nogle_exam.service.domain.IBtseApiService
import com.marker.nogle_exam.ui.page.apage.domain.repository.MarketRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MarketRepositoryImpl(private val btseApiService: IBtseApiService) : MarketRepository {

    override suspend fun getSortedSpotNameList(): Flow<List<String>> {
        return flow {
            emit(btseApiService
                .getMarket()
                .data
                .filter { !it.future }
                .map {
                    it.symbol
                }.sorted()
            )
        }
    }

    override suspend fun getSortedFuturesNameList(): Flow<List<String>> {
        return flow {
            emit(btseApiService
                .getMarket()
                .data
                .filter { it.future }
                .map {
                    it.symbol
                }.sorted()
            )
        }
    }
}