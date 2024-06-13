package com.cse234.healthtracker.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowBack
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.cse234.healthtracker.R
import com.cse234.healthtracker.data.ActivityData
import com.cse234.healthtracker.viewmodels.ActivityViewModel
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun ActivityHistoryScreen(activityViewModel: ActivityViewModel, navController: NavHostController) {
    val activities by activityViewModel.activities.collectAsState()


    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.start_exercise3))
            .padding(30.dp),
        verticalArrangement = Arrangement.Top,
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
                Icon(imageVector = Icons.AutoMirrored.Rounded.ArrowBack, contentDescription ="" )
            }
            Text(
                text = "Activity History : ${activityViewModel.selectedActivity}",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        if (activities.isEmpty()){
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
                items(activities) {
                    ActivityCard(activity = it)
                }
            }
        }
    }

}

@Composable
fun ActivityCard(activity: ActivityData) {

    val dateFormat = SimpleDateFormat("dd/MM", Locale.getDefault())
    val distanceFormatted = String.format("%.1f", activity.distance * 1000)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        colorResource(id = R.color.activity_card1),
                        colorResource(id = R.color.activity_card2),
                        colorResource(id = R.color.activity_card3),
                        colorResource(id = R.color.activity_card4)
                    )
                ),
                shape = RoundedCornerShape(30.dp)
            )
            .shadow(
                elevation = 90.dp,
                shape = RoundedCornerShape(30.dp),
                clip = false,
                ambientColor = Color.Green,
                spotColor = colorResource(id = R.color.bottom_tab_bar)
            )
            .padding(8.dp)
            .height(100.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent,
            contentColor = colorResource(R.color.black)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 50.dp
        ),
        shape = RoundedCornerShape(30.dp)
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 8.dp, top = 8.dp, bottom = 8.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ){
            Row (
                horizontalArrangement = Arrangement.spacedBy(15.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text =activity.activityType , fontSize = 25.sp , fontWeight = FontWeight.Bold , fontFamily = FontFamily.SansSerif , color = colorResource(R.color.weight_bg))
                Text(text = dateFormat.format(activity.date)+"/2024", fontSize = 20.sp , fontWeight = FontWeight.Bold , fontFamily = FontFamily.SansSerif, color = colorResource(R.color.weight_text))
            }
            Text(text = "Duration : ${activity.duration} seconds" , fontSize = 16.sp , fontWeight = FontWeight.Bold , fontFamily = FontFamily.SansSerif , color = colorResource(R.color.black))
            Text(text = "Distance : $distanceFormatted meters" , fontSize = 16.sp , fontWeight = FontWeight.Bold , fontFamily = FontFamily.SansSerif , color = colorResource(R.color.black))

        }

    }
    Spacer(modifier =Modifier.height(10.dp))
}