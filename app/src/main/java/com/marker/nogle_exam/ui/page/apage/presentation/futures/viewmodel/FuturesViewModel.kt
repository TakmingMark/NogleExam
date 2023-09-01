package com.marker.nogle_exam.ui.page.apage.presentation.futures.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marker.nogle_exam.ui.page.apage.domain.repository.MarketRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class FuturesViewModel(private val marketRepository: MarketRepository) : ViewModel() {
    private val _sortedFuturesPriceNameListState = MutableStateFlow<List<String>>(emptyList())
    val sortedFuturesPriceNameListState = _sortedFuturesPriceNameListState.asStateFlow()

    fun fetchSortedFuturesPriceNameList() {
        viewModelScope.launch {
            marketRepository
                .getSortedFuturesPriceNameList()
                .flowOn(Dispatchers.IO)
                .collect {
                    _sortedFuturesPriceNameListState.value = it
                }
        }
    }
}