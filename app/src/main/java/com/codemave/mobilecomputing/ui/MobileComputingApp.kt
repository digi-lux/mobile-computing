package com.codemave.mobilecomputing.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.codemave.mobilecomputing.MobileComputingAppState
import com.codemave.mobilecomputing.rememberMobileComputingAppState
import com.codemave.mobilecomputing.ui.home.Home
import com.codemave.mobilecomputing.ui.login.Login
import com.codemave.mobilecomputing.ui.payment.Payment

@Composable
fun MobileComputingApp(
    appState: MobileComputingAppState = rememberMobileComputingAppState()
) {
    NavHost(
        navController = appState.navController,
        startDestination = "login"
    ) {
        composable(rou) {
            Login(navController = appState.navController)
        }
        composable(route = "home") {
            Home()
        }
        composable(route = "payment") {
            Payment(onBackPress = appState::navigateBack)
        }
    }
}