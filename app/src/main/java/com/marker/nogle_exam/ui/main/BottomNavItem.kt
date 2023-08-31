package com.marker.nogle_exam.ui.main

sealed class BottomNavItem(
    val route: String,
    val title: String
) {
    object AScreen :
        BottomNavItem(
            "AScreen",
            "A Screen"
        )

    object BScreen :
        BottomNavItem(
            "BScreen",
            "B Screen"
        )

    object CScreen :
        BottomNavItem(
            "CScreen",
            "C Screen"
        )

    object DScreen :
        BottomNavItem(
            "CScreen",
            "D Screen"
        )
}