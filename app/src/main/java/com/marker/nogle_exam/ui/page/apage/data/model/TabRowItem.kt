package com.marker.nogle_exam.ui.page.apage.data.model

import androidx.compose.runtime.Composable

data class TabRowItem(
    val title: String,
    val screen: @Composable () -> Unit,
)