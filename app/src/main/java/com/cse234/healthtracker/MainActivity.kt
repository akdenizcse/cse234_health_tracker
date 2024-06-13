package com.cse234.healthtracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cse234.healthtracker.screens.AboutScreen
import com.cse234.healthtracker.screens.ActivitiesScreen
import com.cse234.healthtracker.screens.ActivityHistoryScreen
import com.cse234.healthtracker.screens.EnergyConsumptionScreen
import com.cse234.healthtracker.screens.HeightWeightScreen
import com.cse234.healthtracker.screens.HomeScreen
import com.cse234.healthtracker.screens.LoginProcedure
import com.cse234.healthtracker.screens.LoginScreen
import com.cse234.healthtracker.screens.NotificationScreen
import com.cse234.healthtracker.screens.PastActivitiesScreen
import com.cse234.healthtracker.screens.PersonalInfoScreen
import com.cse234.healthtracker.screens.RegisterProcedure
import com.cse234.healthtracker.screens.SleepScreen
import com.cse234.healthtracker.screens.TimerScreenContent
import com.cse234.healthtracker.screens.UserProfileScreen
import com.cse234.healthtracker.ui.theme.HealthTrackerProjectTheme
import com.cse234.healthtracker.viewmodels.ActivityViewModel
import com.cse234.healthtracker.viewmodels.TimerViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HealthTrackerProjectTheme {
                val navController = rememberNavController()
                val timerViewModel: TimerViewModel by viewModels()
                val activityViewModel: ActivityViewModel by viewModels()
                NavHost(
                    navController = navController,
                    startDestination = "LoginScreen"
                ) {
                    composable("LoginScreen") {
                        LoginScreen(navController = navController)
                    }
                    composable("LoginProcedure") {
                        LoginProcedure(navController = navController)
                    }
                    composable("RegisterProcedure") {
                        RegisterProcedure(navController = navController)
                    }
                    composable("HomeScreen") {
                        HomeScreen(
                            navController = navController,
                            activityViewModel = activityViewModel
                        )
                    }
                    composable("UserProfileScreen") {
                        UserProfileScreen(navController = navController)
                    }
                    composable("ActivitiesScreen") {
                        ActivitiesScreen(navController = navController, activityViewModel)
                    }
                    composable("TimerScreen") {
                        TimerScreenContent(timerViewModel, activityViewModel, navController)
                    }
                    composable("ActivityHistoryScreen") {
                        ActivityHistoryScreen(activityViewModel, navController)
                    }
                    composable("NotificationScreen") {
                        NotificationScreen(navController)
                    }
                    composable("PersonalInfoScreen") {
                        PersonalInfoScreen(navController = navController)
                    }
                    composable("HeightWeightScreen") {
                        HeightWeightScreen(navController = navController)
                    }
                    composable("PastActivities") {
                        PastActivitiesScreen(activityViewModel, navController)
                    }
                    composable("EnergyConsumptionScreen") {
                        EnergyConsumptionScreen(activityViewModel, navController)
                    }
                    composable("SleepScreen") {
                        SleepScreen(navController = navController)
                    }
                    composable("AboutScreen") {
                        AboutScreen(navController = navController)
                    }
                }

            }
        }
    }
}

