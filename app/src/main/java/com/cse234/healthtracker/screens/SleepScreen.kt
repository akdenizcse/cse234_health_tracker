package com.cse234.healthtracker.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.cse234.healthtracker.R


@Composable
fun SleepScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.sleepbg))
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "About Sleep",
            fontSize = 32.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(color = colorResource(id = R.color.key_points))
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "KEY POINTS",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF00796B),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(text = "• Good sleep is essential for our health and emotional well-being.")
                Text(text = "• Getting enough sleep and good sleep quality are essential for healthy sleep.")
                Text(text = "• The amount of sleep you need changes as you age.")
                Text(text = "• Talk to your healthcare provider if you have problems sleeping.")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Image(
                painter = painterResource(id = R.drawable.sleep),
                contentDescription = "Sleeping person",
                modifier = Modifier
                    .size(150.dp)
                    .align(Alignment.CenterVertically)
            )
        }
        Card(modifier = Modifier.size(330.dp,145.dp)) {
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                Row (
                    Modifier
                        .fillMaxWidth()
                        .background(color = colorResource(id = R.color.tableblue))
                        .padding(horizontal = 7.dp)
                    ,
                    horizontalArrangement = Arrangement.SpaceBetween){
                    Text(text = "Age Group", fontSize = 17.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Age ", fontSize = 17.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Recommended Daily", fontSize = 17.sp, fontWeight = FontWeight.Bold)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White)
                        .padding(horizontal = 7.dp),
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    Text(text = "Infant", fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    Text(text = "4-12 months", fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    Text(text = "12-16 Hours", fontSize = 15.sp, fontWeight = FontWeight.Bold)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.LightGray)
                        .padding(horizontal = 7.dp),
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    Text(text = "Toddler", fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    Text(text = "1-2 years old", fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    Text(text = "11-14 Hours", fontSize = 15.sp, fontWeight = FontWeight.Bold)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White)
                        .padding(horizontal = 7.dp),
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    Text(text = "Preschool", fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    Text(text = "3-5 years old", fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    Text(text = "10-13 Hours", fontSize = 15.sp, fontWeight = FontWeight.Bold)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.LightGray)
                        .padding(horizontal = 7.dp),
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    Text(text = "School age", fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    Text(text = "6-12 years old", fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    Text(text = "9-12 Hours", fontSize = 15.sp, fontWeight = FontWeight.Bold)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White)
                        .padding(horizontal = 7.dp),
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    Text(text = "Teen", fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    Text(text = "13-18 years old", fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    Text(text = "8-10 Hours", fontSize = 15.sp, fontWeight = FontWeight.Bold)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.LightGray)
                        .padding(horizontal = 7.dp),
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    Text(text = "Adult", fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    Text(text = "18 years andolder", fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    Text(text = "7 Hours or more", fontSize = 15.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
    Row (Modifier.fillMaxSize().padding(horizontal = 3.dp, vertical = 5.dp)){

        IconButton(onClick = {
            if (navController.previousBackStackEntry != null) {
                navController.popBackStack()
            }
        }) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
        }
    }
}

