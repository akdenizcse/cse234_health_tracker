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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
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
fun AboutScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.login_bg))
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ){
            IconButton(onClick = {
                if (navController.previousBackStackEntry != null) {
                    navController.navigateUp()
                }
            }) {
                Icon(imageVector = Icons.AutoMirrored.Rounded.ArrowBack, contentDescription ="" )
            }
        }
        Image(painter = painterResource(id = R.drawable.better_health) , contentDescription = "")
        Card(
            modifier = Modifier
                .size(400.dp, 230.dp)
                .background(color = Color.LightGray),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(20.dp)) {
                Text(text = "Term of Use",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.Black
                )
                Text(text = "Welcome to Health Tracker!", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(text = "This is Health Tracker Term of Use")
                Text(text = "Our application aims to maintain human health and fitness." +
                        " It does this by encouraging daily exercise and providing sleep pattern recommendations. " +
                        "Additionally, it helps track the development process by recording daily activities.")
            }

        }
        Spacer(modifier = Modifier.height(20.dp))
        Card(
            modifier = Modifier
                .size(400.dp, 240.dp)
                .background(color = Color.LightGray),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(20.dp)) {
                Text(text = "Privacy Policy",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.Black
                )
                Text(text = "At Health Tracker, we take your privacy seriously." +
                        " This privacy policy explains how we collect, use and protect your personel information.")
                Text(text = "Information we collect:", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(text = "1-Name,Surname")
                Text(text = "2-Email-Password")
                Text(text = "3-Height-Weight")
                Text(text = "4-Daily Activities")
            }

        }

    }

}