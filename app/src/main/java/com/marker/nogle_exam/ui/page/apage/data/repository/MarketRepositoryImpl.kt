package com.marker.nogle_exam.ui.page.apage.data.repository

import com.marker.nogle_exam.service.IBtseApiService
import com.marker.nogle_exam.ui.page.apage.domain.repository.MarketRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MarketRepositoryImpl(private val btseApiService: IBtseApiService) : MarketRepository {

    override suspend fun getSortedSpotPriceNameList(): Flow<List<String>> {
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

    override suspend fun getSortedFuturePriceNameList(): Flow<List<String>> {
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