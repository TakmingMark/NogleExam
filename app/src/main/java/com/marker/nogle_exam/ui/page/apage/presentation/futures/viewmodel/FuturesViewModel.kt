package com.marker.nogle_exam.ui.page.apage.presentation.futures.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marker.nogle_exam.ui.page.apage.domain.repository.FuturesRepository
import com.marker.nogle_exam.ui.page.apage.domain.repository.MarketRepository
import com.marker.nogle_exam.until.ArrayUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class FuturesViewModel(
    private val marketRepository: MarketRepository,
    private val futuresRepository: FuturesRepository
) : ViewModel() {
    private val _sortedFuturesNameAndPriceListState =
        MutableStateFlow<List<Pair<String, String>>>(emptyList())
    val sortedFuturesNameAndPriceListState = _sortedFuturesNameAndPriceListState.asStateFlow()

    fun fetchSortedFuturesNameAndPriceList() {
        viewModelScope.launch {
            futuresRepository.getFilterPrices(1)
                .combine(marketRepository.getSortedFuturesNameList()) { prices, sortedFuturesNameList ->
                    ArrayUtils.mergeTwoListToPairList(
                        sortedFuturesNameList,
                        prices.map { it.toString() })
                }
                .flowOn(Dispatchers.IO)
                .collect {
                    _sortedFuturesNameAndPriceListState.value = it
                }
        }
    }
}