package com.example.vehicheck

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.vehicheck.ui.theme.LoginScreen
import com.example.vehicheck.ui.theme.RegisterScreen
import com.example.vehicheck.ui.theme.RecoverPasswordScreen
import com.example.vehicheck.ui.theme.VehicheckTheme
import com.example.vehicheck.ui.theme.ChangePasswordScreen
import com.example.vehicheck.ui.theme.DashboardScreen
import com.example.vehicheck.ui.theme.FuelManagementScreen
import com.example.vehicheck.ui.theme.MaintenanceManagementScreen
import com.example.vehicheck.ui.theme.FuelEntryScreen
import com.example.vehicheck.ui.theme.MaintenanceEntryScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VehicheckTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "login") {
                    composable("login") {
                        LoginScreen(
                            onRegisterClick = { navController.navigate("register") },
                            onRecoverPasswordClick = { navController.navigate("recover_password") },
                            onChangePasswordClick = { navController.navigate("change_password") },
                            onLoginClick = { navController.navigate("dashboard") }
                        )
                    }
                    composable("register") {
                        RegisterScreen(onNavigateToChangePassword = { navController.navigate("change_password") })
                    }
                    composable("recover_password") {
                        RecoverPasswordScreen(onAcceptClick = { navController.navigate("change_password") })
                    }
                    composable("change_password") {
                        ChangePasswordScreen(onAcceptClick = { navController.popBackStack("login", inclusive = false) })
                    }
                    composable("dashboard") {
                        DashboardScreen(
                            navController = navController,
                            onLogoutClick = { navController.popBackStack("login", inclusive = false) }
                        )
                    }
                    composable("fuel_management") {
                        FuelManagementScreen(
                            navController = navController,
                            onBackClick = { navController.popBackStack() }
                        )
                    }
                    composable("maintenance_management") {
                        MaintenanceManagementScreen(
                            navController = navController,
                            onBackClick = { navController.popBackStack() }
                        )
                    }
                    composable("fuel_entry") {
                        FuelEntryScreen(
                            onBackClick = { navController.popBackStack() },
                            onSaveClick = { navController.popBackStack() }
                        )
                    }
                    composable("maintenance_entry") {
                        MaintenanceEntryScreen(
                            onBackClick = { navController.popBackStack() },
                            onSaveClick = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}
