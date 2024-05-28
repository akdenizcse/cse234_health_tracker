package com.cse234.healthtracker.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
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
            .padding(30.dp)
    ){
        Text(
            text = "Activity History : ${activityViewModel.selectedActivity}",
            modifier = Modifier.padding(start = 10.dp , top = 16.dp),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))
        if (activities.isEmpty()){
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(start = 8.dp, top = 16.dp)
            ){
                Text(text = "No activities found" , color = colorResource(R.color.black))
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

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(100.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.user_page_bg),
            contentColor = colorResource(R.color.black)
        )
    ) {
        Row (
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text =activity.activityType , fontSize = 16.sp , fontWeight = FontWeight.Bold)
            Text(text = dateFormat.format(activity.date), fontSize = 16.sp , fontWeight = FontWeight.Bold)
        }

    }

}