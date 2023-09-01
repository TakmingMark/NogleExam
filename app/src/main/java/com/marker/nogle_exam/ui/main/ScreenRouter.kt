package com.marker.nogle_exam.ui.main

sealed class ScreenRouter(val route: String) {
    object AScreen : ScreenRouter("AScreen")
    object BScreen : ScreenRouter("BScreen")
    object CScreen : ScreenRouter("CScreen")
    object DScreen : ScreenRouter("DScreen")
    object SettingScreen : ScreenRouter("SettingScreen")
}