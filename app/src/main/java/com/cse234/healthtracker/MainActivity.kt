package com.cse234.healthtracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import com.cse234.healthtracker.screens.LoginScreen
import com.cse234.healthtracker.ui.theme.HealthTrackerProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HealthTrackerProjectTheme {
                val navController = rememberNavController()
                NavHost(
                    navController =navController ,
                    startDestination = "LoginScreen"
                ){
                 composable("LoginScreen"){
                     LoginScreen(navController = navController)
                 }
                }

            }
        }
    }
}

