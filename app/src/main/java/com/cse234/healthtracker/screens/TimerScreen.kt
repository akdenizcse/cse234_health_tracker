package com.cse234.healthtracker.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.cse234.healthtracker.R
import com.cse234.healthtracker.data.ActivityData
import com.cse234.healthtracker.data.formatTime
import com.cse234.healthtracker.viewmodels.ActivityViewModel
import com.cse234.healthtracker.viewmodels.TimerViewModel
import java.util.Date

@Composable
fun TimerScreenContent(timerViewModel: TimerViewModel , activityViewModel: ActivityViewModel , navController: NavHostController) {
    val timerValue by timerViewModel.timer.collectAsState()
    val isLoaded by activityViewModel.isLoaded.collectAsState()

    TimerScreen(
        timerValue = timerValue,
        onStartClick = { timerViewModel.startTimer() },
        onPauseClick = { timerViewModel.pauseTimer() },
        onStopClick = { timerViewModel.stopTimer() },
        timerViewModel,
        activityViewModel,
        isLoaded,
        navController
    )
}

@Composable
fun TimerScreen(
    timerValue: Long,
    onStartClick: () -> Unit,
    onPauseClick: () -> Unit,
    onStopClick: () -> Unit,
    timerViewModel: TimerViewModel,
    activityViewModel: ActivityViewModel,
    isLoaded : Boolean?,
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.user_page_bg)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            IconButton(onClick = {
                if (navController.previousBackStackEntry != null) {
                    activityViewModel.resetIsLoaded()
                    navController.popBackStack()
                }
            },modifier = Modifier
                .padding(start = 10.dp , top = 26.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack, // Replace with your back arrow icon
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }
        }
        Row (horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ){
            Card (
                modifier = Modifier
                    .padding(horizontal = 25.dp, vertical = 80.dp)
                    .size(160.dp, 150.dp)
                    .shadow(
                        elevation = 90.dp,
                        shape = RoundedCornerShape(16.dp),
                        clip = false,
                        ambientColor = Color.Green,
                        spotColor = colorResource(id = R.color.white)
                    )
                ,
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(id = R.color.login_bg),
                    contentColor = Color.Black
                ),
                elevation = CardDefaults.cardElevation(16.dp)
            ){
                Image(painter = painterResource(R.drawable.walking), contentDescription ="logo",
                    Modifier
                        .size(150.dp)
                        .padding(start = 15.dp) )
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        Card (
            modifier = Modifier
                .padding(horizontal = 25.dp, vertical = 2.dp)
                .size(160.dp, 50.dp)
                .shadow(
                    elevation = 90.dp,
                    shape = RoundedCornerShape(16.dp),
                    clip = false,
                    ambientColor = Color.Green,
                    spotColor = colorResource(id = R.color.white)
                )
            ,
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.login_bg),
                contentColor = Color.Black
            ),
            elevation = CardDefaults.cardElevation(16.dp)
        ){
            Text(text = timerValue.formatTime(),
                fontSize = 24.sp,
                modifier = Modifier.padding(horizontal = 30.dp, vertical = 8.dp),
                color = colorResource(R.color.user_page_bg)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Spacer(modifier = Modifier.width(50.dp))
            startButton (onStartClick)
            Spacer(modifier = Modifier.width(30.dp))
            pauseButton (onPauseClick)

            Spacer(modifier = Modifier.width(30.dp))
            stopButton (onStopClick , activityViewModel , timerViewModel)
        }
        when(isLoaded) {
            true -> {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(90.dp)
                        .padding(start = 50.dp, top = 24.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ){
                    Image(painter = painterResource(R.drawable.approved), contentDescription ="")
                    Text(text = "Successfully Added!")
                }
            }
            false -> {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(90.dp)
                        .padding(start = 50.dp, top = 24.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ){
                    Image(painter = painterResource(R.drawable.error), contentDescription ="" )
                    Text(text = "Activity could not be saved!")
                }
            }
            else -> {/**/}
        }
    }

}

@Composable
fun startButton(onStartClick: () -> Unit){
    IconButton(onClick =  onStartClick ,
        modifier = Modifier
            .size(75.dp)
            .fillMaxSize(),
    ) {
        Image(painter = painterResource(R.drawable.play_button), contentDescription ="logo",
            Modifier.size(75.dp) )
    }
}
@Composable
fun pauseButton(onPauseClick: () -> Unit){
    IconButton(onClick =  onPauseClick ,
        modifier = Modifier
            .size(75.dp)
            .fillMaxSize(),
    ) {
        Image(painter = painterResource(R.drawable.pause_button), contentDescription ="logo" ,
            Modifier.size(75.dp))
    }
}

@Composable
fun stopButton(onStopClick: () -> Unit , activityViewModel: ActivityViewModel, timerViewModel: TimerViewModel){
    IconButton(
        onClick = {
            onStopClick()
            val data = activityViewModel.userId?.let {
                ActivityData(
                    userId = activityViewModel.userId,
                    activityType = activityViewModel.selectedActivity,
                    startTime = timerViewModel.startTime,
                    endTime = timerViewModel.endTime,
                    duration = timerViewModel.timer.value,
                    distance = calculateDistanceForActivity(activityViewModel.selectedActivity , timerViewModel.timer.value),
                    date = Date()
                )
            }
            data?.let {
                activityViewModel.loadDataToFireStore(data)
            }
        } ,
        modifier = Modifier
            .size(75.dp)
            .fillMaxSize(),
    ) {
        Image(painter = painterResource(R.drawable.stop_button), contentDescription ="logo" ,
            Modifier.size(75.dp))
    }

}

fun calculateDistanceForActivity(activityType: String, durationInSeconds: Long): Double {
    val speedInKmPerHour = when (activityType.lowercase()) {
        "walking" -> 5.0 // 5 km/h
        "jogging" -> 8.0 // 8 km/h
        "running" -> 12.0 // 12 km/h
        "cycling" -> 20.0 // 20 km/h
        "swimming" -> 2.0 // 2 km/h
        "yoga" -> 0.0 // yoga typically doesn't cover distance
        else -> 0.0 // default speed for unknown activities
    }

    val durationInHours = durationInSeconds / 3600.0
    return speedInKmPerHour * durationInHours
}