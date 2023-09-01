package com.marker.nogle_exam.ui.page.apage

import androidx.lifecycle.ViewModel
import com.marker.nogle_exam.ui.page.apage.data.model.TabRowItem
import com.marker.nogle_exam.ui.page.apage.presentation.futures.view.FuturesScreen
import com.marker.nogle_exam.ui.page.apage.presentation.spot.view.SpotScreen

class AScreenViewModel : ViewModel() {
    fun getTabRowItems(): List<TabRowItem> {
        return listOf(
            TabRowItem(
                title = "Spot",
                screen = { SpotScreen() },
            ),
            TabRowItem(
                title = "Futures",
                screen = { FuturesScreen() },
            ),
        )
    }
}