package com.marker.nogle_exam.ui.page.apage.presentation.spot.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marker.nogle_exam.ui.page.apage.domain.repository.MarketRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class SpotViewModel(private val marketRepository: MarketRepository) : ViewModel() {
    private val _sortedSpotPriceNameListState = MutableStateFlow<List<String>>(emptyList())
    val sortedSpotPriceNameListState = _sortedSpotPriceNameListState.asStateFlow()

    fun fetchSortedSpotPriceNameList() {
        viewModelScope.launch {
            marketRepository
                .getSortedSpotPriceNameList()
                .flowOn(Dispatchers.IO)
                .collect {
                    _sortedSpotPriceNameListState.value = it
                }
        }
    }
}