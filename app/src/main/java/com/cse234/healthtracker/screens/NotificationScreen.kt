package com.cse234.healthtracker.screens

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.cse234.healthtracker.R

@Composable
fun NotificationScreen(navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(
            color = colorResource(id = R.color.home_screen_bg))
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(60.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {
                    if(navController.previousBackStackEntry != null){
                        navController.navigateUp()
                    }
                }
            ) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "",
                    tint = Color.Black,
                    modifier = Modifier.size(40.dp)
                )

            }
            Text(
                text = "Notifications",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
            )
        }
        Spacer(modifier = Modifier.height(60.dp))
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth().padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column() {
                Text(
                    text = "Allow notifications ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = colorResource(id = R.color.user_page_bg)
                )
            }
            switchButton()
        }

        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column {
                Text(
                    text = "Allow step goal notifications ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = colorResource(id = R.color.user_page_bg)
                )
            }
            switchButton()
        }
    }

}

@Composable
fun switchButton(){
    var isChecked by remember { mutableStateOf(true) }
    Switch(checked = isChecked,
        onCheckedChange ={isChecked=it} ,
        colors = SwitchDefaults.colors(
            checkedTrackColor = colorResource(id = R.color.user_page_bg),
            uncheckedTrackColor = colorResource(id = R.color.home_screen_bg)
        ),
        thumbContent = {
            Icon(
                imageVector = Icons.Filled.Check,
                contentDescription = null,
                modifier = Modifier.size(50.dp),
            )
        }
    )
}