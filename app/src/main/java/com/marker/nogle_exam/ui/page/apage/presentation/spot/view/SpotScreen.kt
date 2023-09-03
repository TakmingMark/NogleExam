package com.marker.nogle_exam.ui.page.apage.presentation.spot.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import com.marker.nogle_exam.ui.page.apage.presentation.spot.viewmodel.SpotViewModel
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.koinViewModel

@Composable
fun SpotScreen() {
    val viewModel = koinViewModel<SpotViewModel>()
    val sortedSpotNameAndPriceListState = remember { mutableStateListOf<Pair<String, String>>() }

    val lifecycleOwner = LocalLifecycleOwner.current
    LaunchedEffect(key1 = Unit) {
        viewModel.fetchSortedSpotNameAndPriceList()
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            viewModel.sortedSpotNameAndPriceListState.collectLatest {
                sortedSpotNameAndPriceListState.clear()
                sortedSpotNameAndPriceListState.addAll(it)
            }
        }
    }

    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(sortedSpotNameAndPriceListState.size) {
            Row {
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 30.dp),
                    text = sortedSpotNameAndPriceListState[it].first,
                    textAlign = TextAlign.Start
                )
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 30.dp),
                    text = sortedSpotNameAndPriceListState[it].second,
                    textAlign = TextAlign.End
                )
            }
        }
    }
}