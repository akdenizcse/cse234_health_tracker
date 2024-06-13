package com.cse234.healthtracker.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.cse234.healthtracker.R
import com.cse234.healthtracker.viewmodels.ActivityViewModel

@Composable
fun EnergyConsumptionScreen(activityViewModel: ActivityViewModel, navController : NavHostController) {
    LaunchedEffect(Unit) {
        activityViewModel.clearDailyActivities()
        activityViewModel.fetchDailyActivities()
    }

    val totalDistance = remember { mutableStateOf("0.0") }
    val totalDuration = remember { mutableStateOf("0") }
    val totalSteps = remember { mutableIntStateOf(0) }
    val totalCaloriesBurned = remember { mutableDoubleStateOf(0.0) }


    LaunchedEffect(activityViewModel.dailyActivities.collectAsState().value) {
        totalDistance.value = activityViewModel.calculateTotalDistance().replace(",", ".")
        totalDuration.value = activityViewModel.calculateTotalDuration().replace(",", ".")
        totalSteps.intValue = calculateEstimatedSteps(totalDistance.value.toDouble())
        totalCaloriesBurned.doubleValue = calculateEstimatedCaloriesBurned(totalDuration.value.toLong())
    }



    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 25.dp)
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
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ){
            IconButton(onClick = {
                if (navController.previousBackStackEntry != null) {
                    navController.navigateUp()
                }
            }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
            }
            Text(text = "Today's Statics" , fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, end = 25.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ){
            Card (
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 2.dp)
                    .size(140.dp, 140.dp)
                    .shadow(
                        elevation = 90.dp,
                        shape = RoundedCornerShape(16.dp),
                        clip = false,
                        ambientColor = Color.Green,
                        spotColor = colorResource(id = R.color.white)
                    )
                ,
                border = CardDefaults.outlinedCardBorder(),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(16.dp)
            ){
                Column (
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    colorResource(R.color.running_bg),
                                    colorResource(R.color.white)
                                )
                            ),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(vertical = 8.dp, horizontal = 10.dp)
                ){
                    Text(text = "Today's total duration", fontSize = 17.sp, fontWeight = FontWeight.Bold , fontFamily = FontFamily.Serif , color = Color.Black)
                    Image(painter = painterResource(R.drawable.hourglass), contentDescription ="" , modifier = Modifier.size(60.dp))
                }
            }
            Text(text = totalDuration.value, fontSize = 36.sp, fontWeight = FontWeight.Bold , fontFamily = FontFamily.Serif , color = Color.White)
            Spacer(modifier =Modifier.width(5.dp))
            Text(text = "seconds" , fontSize = 17.sp, fontWeight = FontWeight.Thin , fontFamily = FontFamily.Serif)
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, end = 25.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ){
            Card (
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 2.dp)
                    .size(140.dp, 140.dp)
                    .shadow(
                        elevation = 90.dp,
                        shape = RoundedCornerShape(16.dp),
                        clip = false,
                        ambientColor = Color.Green,
                        spotColor = colorResource(id = R.color.white)
                    )
                ,
                border = CardDefaults.outlinedCardBorder(),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(16.dp)
            ){
                Column (
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    colorResource(R.color.weight_bg),
                                    colorResource(R.color.teal_700)
                                )
                            ),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(vertical = 8.dp, horizontal = 10.dp)
                ){
                    Text(text = "Today's total distance", fontSize = 17.sp, fontWeight = FontWeight.Bold , fontFamily = FontFamily.Serif , color = Color.Black)
                    Image(painter = painterResource(R.drawable.walking), contentDescription ="" , modifier = Modifier.size(60.dp))
                }
            }
            Text(text = totalDistance.value, fontSize = 36.sp, fontWeight = FontWeight.Bold , fontFamily = FontFamily.Serif , color = Color.White)
            Spacer(modifier =Modifier.width(5.dp))
            Text(text = "meters" , fontSize = 17.sp, fontWeight = FontWeight.Thin , fontFamily = FontFamily.Serif)
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, end = 25.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ){
            Card (
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 2.dp)
                    .size(140.dp, 140.dp)
                    .shadow(
                        elevation = 90.dp,
                        shape = RoundedCornerShape(16.dp),
                        clip = false,
                        ambientColor = Color.Green,
                        spotColor = colorResource(id = R.color.white)
                    )
                ,
                border = CardDefaults.outlinedCardBorder(),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(16.dp)
            ){
                Column (
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    colorResource(R.color.user_page_bg),
                                    colorResource(R.color.teal_700)
                                )
                            ),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(vertical = 8.dp, horizontal = 10.dp)

                ){
                    Text(text = "Today's total calories burned", fontSize = 17.sp, fontWeight = FontWeight.Bold , fontFamily = FontFamily.Serif , color = Color.Black)
                    Image(painter = painterResource(R.drawable.calories), contentDescription ="" , modifier = Modifier.size(60.dp))
                }
            }
            Text(text = String.format("%.1f",totalCaloriesBurned.doubleValue).replace(",", "."), fontSize = 36.sp, fontWeight = FontWeight.Bold , fontFamily = FontFamily.Serif , color = Color.White)
            Spacer(modifier =Modifier.width(5.dp))
            Text(text = "kcal" , fontSize = 17.sp, fontWeight = FontWeight.Thin , fontFamily = FontFamily.Serif)
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
    }


}