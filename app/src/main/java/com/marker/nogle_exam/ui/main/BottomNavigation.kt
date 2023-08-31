package com.marker.nogle_exam.ui.main

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun BottomNavigation(itemClickedListener: (BottomNavItem) -> Unit) {
    val items = listOf(
        BottomNavItem.AScreen,
        BottomNavItem.BScreen,
        BottomNavItem.CScreen,
        BottomNavItem.DScreen
    )

    NavigationBar {
        items.forEach { item ->
            AddItem(screen = item, itemClickedListener)
        }
    }
}

@Composable
private fun RowScope.AddItem(
    screen: BottomNavItem,
    onClickedListener: (BottomNavItem) -> Unit
) {
    NavigationBarItem(
        // The icon resource
        icon = {
            Text(text = screen.title)
        },

        // Display if the icon it is select or not
        selected = true,

        // Always show the label bellow the icon or not
        alwaysShowLabel = true,

        // Click listener for the icon
        onClick = { onClickedListener.invoke(screen) },

        // Control all the colors of the icon
        colors = NavigationBarItemDefaults.colors()
    )
}