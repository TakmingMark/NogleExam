package com.marker.nogle_exam.ui.main

sealed class BottomNavItem(
    val router: ScreenRouter,
    val title: String
) {
    object AScreen :
        BottomNavItem(
            ScreenRouter.AScreen,
            "A Screen"
        )

    object BScreen :
        BottomNavItem(
            ScreenRouter.BScreen,
            "B Screen"
        )

    object CScreen :
        BottomNavItem(
            ScreenRouter.CScreen,
            "C Screen"
        )

    object DScreen :
        BottomNavItem(
            ScreenRouter.DScreen,
            "D Screen"
        )

}