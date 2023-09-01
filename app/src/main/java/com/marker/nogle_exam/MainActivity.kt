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
import com.marker.nogle_exam.ui.main.BottomNavItem
import com.marker.nogle_exam.ui.main.BottomNavigation
import com.marker.nogle_exam.ui.page.BScreen
import com.marker.nogle_exam.ui.page.CScreen
import com.marker.nogle_exam.ui.page.DScreen
import com.marker.nogle_exam.ui.page.apage.AScreen
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
                    val navigationState =
                        remember { mutableStateOf<BottomNavItem>(BottomNavItem.AScreen) }
                    Scaffold(
                        bottomBar = {
                            BottomNavigation {
                                navigationState.value = it
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
                                startDestination = BottomNavItem.AScreen.route
                            ) {
                                composable(BottomNavItem.AScreen.route) {
                                    AScreen()
                                }
                                composable(BottomNavItem.BScreen.route) {
                                    BScreen()
                                }
                                composable(BottomNavItem.CScreen.route) {
                                    CScreen()
                                }
                                composable(BottomNavItem.DScreen.route) {
                                    DScreen()
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
fun MainScreen(navController: NavController, navigationState: MutableState<BottomNavItem>) {
    navController.navigate(navigationState.value.route)
}