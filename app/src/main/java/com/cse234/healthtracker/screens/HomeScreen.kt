package com.cse234.healthtracker.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cse234.healthtracker.R


@Composable
fun HomeScreen(navController: NavHostController) {
    Column (
        modifier = Modifier
            .background(color = colorResource(id = R.color.login_bg)),
    ){
        HomeScreenTopCard()
        HomeScreenBottomTabBar(navController)

    }
}

@Composable
private fun HomeScreenBottomTabBar(navController: NavHostController){

    Box (
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ){
        Row (
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(colorResource(id = R.color.bottom_tab_bar))



        ){
            IconButton( // HOME PAGE BUTTON
                modifier = Modifier.padding(start = 16.dp, bottom = 50.dp),
                onClick = { /*TODO*/ }
            ) {
                Icon(Icons.Filled.Home, contentDescription = "Home page", modifier = Modifier.size(40.dp))
            }

            IconButton( // ACTIVITIES PAGE BUTTON
                modifier = Modifier.padding(bottom = 50.dp),
                onClick = { /*TODO*/ }
            ) {
                Icon(Icons.Filled.List , contentDescription = "Activities page", modifier = Modifier.size(40.dp))
            }

            IconButton( // USER PROFILE PAGE BUTTON
                modifier = Modifier.padding(end = 16.dp, bottom = 50.dp),
                onClick = { navController.navigate("UserProfileScreen") }
            ) {
                Icon(Icons.Filled.Person, contentDescription = "User page", modifier = Modifier.size(40.dp))
            }
        }
    }
}

@Composable
private fun HomeScreenTopCard(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 30.dp)
            .size(300.dp, 240.dp)
            .shadow(
                elevation = 90.dp,
                shape = RoundedCornerShape(16.dp),
                clip = false,
                ambientColor = Color.Green,
                spotColor = colorResource(id = R.color.white)
            )
        ,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.fade_red),
            contentColor = Color.Black
        ),
        elevation = CardDefaults.cardElevation(16.dp),

        ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = "WELCOME")
            Text(text = "how are you today?")
        }

    }
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Card (
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .size(160.dp, 170.dp)
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
                containerColor = colorResource(id = R.color.fade_red),
                contentColor = Color.Black
            ),
            elevation = CardDefaults.cardElevation(16.dp)
        ){

        }
        Card (
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .size(160.dp, 170.dp)
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
                containerColor = colorResource(id = R.color.fade_red),
                contentColor = Color.Black
            ),
            elevation = CardDefaults.cardElevation(16.dp)
        ){

        }

    }
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Card(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .size(160.dp, 170.dp)
                .shadow(
                    elevation = 90.dp,
                    shape = RoundedCornerShape(16.dp),
                    clip = false,
                    ambientColor = Color.Green,
                    spotColor = colorResource(id = R.color.white)
                ),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.fade_red),
                contentColor = Color.Black
            ),
            elevation = CardDefaults.cardElevation(16.dp)
        ) {

        }
        Card(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .size(160.dp, 170.dp)
                .shadow(
                    elevation = 90.dp,
                    shape = RoundedCornerShape(16.dp),
                    clip = false,
                    ambientColor = Color.Green,
                    spotColor = colorResource(id = R.color.white)
                ),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.fade_red),
                contentColor = Color.Black
            ),
            elevation = CardDefaults.cardElevation(16.dp)
        ) {

        }
    }

}