package com.cse234.healthtracker.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.cse234.healthtracker.R
import com.cse234.healthtracker.viewmodels.ActivityViewModel

@Composable
fun PastActivitiesScreen(activityViewModel: ActivityViewModel, navController : NavHostController) {
    LaunchedEffect(Unit) {
        activityViewModel.clearDailyActivities()
        activityViewModel.fetchDailyActivities()
    }

    val totalDistance = remember { mutableStateOf("0.0") }
    val totalDuration = remember { mutableStateOf("0")}
    val totalSteps = remember { mutableIntStateOf(0) }
    val totalCaloriesBurned = remember { mutableDoubleStateOf(0.0) }
    val dailyActivities = activityViewModel.dailyActivities.collectAsState().value

    LaunchedEffect(activityViewModel.dailyActivities.collectAsState().value) {
        totalDistance.value = activityViewModel.calculateTotalDistance().replace(",", ".")
        totalDuration.value = activityViewModel.calculateTotalDuration().replace(",", ".")
        totalSteps.intValue = calculateEstimatedSteps(totalDistance.value.toDouble())
        totalCaloriesBurned.doubleValue = calculateEstimatedCaloriesBurned(totalDuration.value.toLong())
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 26.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        colorResource(R.color.weight_bg),
                        colorResource(R.color.energy_bg),
                        colorResource(R.color.gray)
                    )

                )
            )
        ,
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ){
            IconButton(onClick = {
                if (navController.previousBackStackEntry != null) {
                    navController.popBackStack()
                }
            }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
            }
            Text(text = "Today's Activity Summary", fontSize =24.sp, fontWeight = FontWeight.Bold)
        }
        CircularProgressBar(
            timePercantage = totalDuration.value.toFloat() / 5200,
            timeNumber = 5200,
            stepsPercantage = calculateEstimatedSteps(totalDistance.value.toDouble()) / 10000f,
            stepsNumber = 10000,
            caloriesPercantage = totalCaloriesBurned.doubleValue.toFloat() / 1000f,
            caloriesNumber = 1000,
            strokeWidth = 8.dp,
            animDuration = 2500,
            animDelay = 0
        )
        Text(text = "Today's activities", fontSize = 30.sp, fontWeight = FontWeight.Medium , color = colorResource(R.color.weight_bg))
        if (dailyActivities.isEmpty()){
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(start = 8.dp, top = 8.dp, bottom = 8.dp)
            ){
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ){
                    Text(text = "No activities found" , color = colorResource(R.color.black))
                }

            }
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                contentPadding = PaddingValues(10.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(dailyActivities) {
                    ActivityCard(activity = it)
                }
            }
        }
    }

}
fun calculateEstimatedSteps(totalDistance: Double): Int {
    val averageStepLengthInKm = 0.8
    return (totalDistance / averageStepLengthInKm).toInt()
}

fun calculateEstimatedCaloriesBurned(totalDurationInSeconds: Long): Double {
    val averageMet = 5.0
    val averageWeightInKg = 70.0
    val durationInHours = totalDurationInSeconds / 3600.0
    return averageMet * averageWeightInKg * durationInHours
}
