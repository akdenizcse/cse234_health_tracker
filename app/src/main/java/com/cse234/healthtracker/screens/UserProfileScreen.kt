package com.cse234.healthtracker.screens


import BottomNavigationBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.sharp.AccountCircle
import androidx.compose.material.icons.sharp.ExitToApp
import androidx.compose.material.icons.twotone.Face
import androidx.compose.material.icons.twotone.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.cse234.healthtracker.R


@Composable
fun UserProfileScreen(navController : NavHostController) {


    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController, onItemClick = { navController.navigate(it.route)})
        }
    ) {innerPadding -> // innerPadding is the padding that is applied by the Scaffold
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(colorResource(id = R.color.user_page_bg))
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = colorResource(R.color.user_page_bg))
                //.padding(horizontal = 24.dp, vertical = 36.dp)
            ) {
                Card(//TOP BAR MESSAGE, LOGOUT BUTTON
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 36.dp, horizontal = 24.dp)
                        .background(color = colorResource(R.color.user_page_bg)),
                    colors = CardDefaults.cardColors(
                        containerColor = colorResource(R.color.fade_black),
                        contentColor = colorResource(R.color.white)
                    )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Me",
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                            fontSize = 44.sp, fontFamily = FontFamily.Serif
                        )
                        Spacer(modifier = Modifier.width(88.dp))
                        Button(
                            onClick = { /*LOGOUT*/ },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(R.color.fade_black),
                                contentColor = colorResource(R.color.white)
                            )

                        ) {
                            Text(text = "LOGOUT")
                            Spacer(modifier = Modifier.width(8.dp))
                            Icon(Icons.Sharp.ExitToApp, contentDescription = "logout")
                        }
                    }


                }

                Row(//USER ICON , USER NAME
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(100.dp)
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        Icons.Sharp.AccountCircle,
                        contentDescription = "user_logo",
                        modifier = Modifier.size(100.dp)
                    )
                    Text(text = "User Name", fontSize = 32.sp, fontFamily = FontFamily.Serif)
                }



                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp, horizontal = 24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {//personal information
                    Image(
                        Icons.TwoTone.Face,
                        contentDescription = "personal info",
                        modifier = Modifier.size(30.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = "Personal Information")
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.KeyboardArrowRight, contentDescription = "")
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp, horizontal = 24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {//notifications
                    Image(
                        Icons.TwoTone.Notifications,
                        contentDescription = "notifications",
                        modifier = Modifier.size(30.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = "Notifications")
                    IconButton(onClick = {navController.navigate("NotificationScreen") }) {
                        Icon(Icons.Filled.KeyboardArrowRight, contentDescription = "")
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp, horizontal = 24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {//about
                    Image(
                        Icons.Rounded.Info,
                        contentDescription = "about",
                        modifier = Modifier.size(30.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = "About")
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.KeyboardArrowRight, contentDescription = "")
                    }
                }

            }
        }

    }


}