package com.marker.nogle_exam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.marker.nogle_exam.ui.main.BottomNavigation
import com.marker.nogle_exam.ui.main.ScreenRouter
import com.marker.nogle_exam.ui.page.BScreen
import com.marker.nogle_exam.ui.page.CScreen
import com.marker.nogle_exam.ui.page.apage.AScreen
import com.marker.nogle_exam.ui.page.dpage.DScreen
import com.marker.nogle_exam.ui.page.dpage.setting.SettingScreen
import com.marker.nogle_exam.ui.theme.Nogle_examTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Nogle_examTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val isHideBottomNav = remember { mutableStateOf(false) }
                    val navigationState =
                        remember { mutableStateOf<ScreenRouter>(ScreenRouter.AScreen) }
                    Scaffold(
                        bottomBar = {
                            if (!isHideBottomNav.value)
                                BottomNavigation {
                                    navigationState.value = it.router
                                }
                        },
                    ) { paddingValues ->
                        Column(
                            modifier = Modifier
                                .padding(paddingValues)
                        ) {

                            val navController = rememberNavController()
                            NavHost(
                                navController = navController,
                                startDestination = ScreenRouter.AScreen.route
                            ) {
                                composable(ScreenRouter.AScreen.route) {
                                    AScreen()
                                }
                                composable(ScreenRouter.BScreen.route) {
                                    BScreen()
                                }
                                composable(ScreenRouter.CScreen.route) {
                                    CScreen()
                                }
                                composable(ScreenRouter.DScreen.route) {
                                    DScreen {
                                        navigationState.value = ScreenRouter.SettingScreen
                                        isHideBottomNav.value = true
                                    }
                                }
                                composable(ScreenRouter.SettingScreen.route) {
                                    SettingScreen {
                                        navController.popBackStack()
                                        navigationState.value = ScreenRouter.DScreen
                                        isHideBottomNav.value = false
                                    }
                                }
                            }

                            MainScreen(navController, navigationState)
                        }
                    }


                }
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavController, navigationState: MutableState<ScreenRouter>) {
    navController.navigate(navigationState.value.route) {
        popUpTo(navigationState.value.route) {
            inclusive = true
        }
    }
}