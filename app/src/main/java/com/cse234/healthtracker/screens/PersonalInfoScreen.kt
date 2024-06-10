package com.cse234.healthtracker.screens

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.cse234.healthtracker.R
import java.util.Calendar
import java.util.Date

@Composable
fun PersonalInfoScreen(navController : NavHostController) {
    val showGenderDialog = remember { mutableStateOf(false) }
    val showBirthDateDialog = remember { mutableStateOf(false) }

    val selectedGender = remember{ mutableStateOf("Unknown")}
    val selectedBirthDate = remember{ mutableStateOf(Date())}

    val context = LocalContext.current
    val calendar  = Calendar.getInstance()

    if(showGenderDialog.value){
        AlertDialog(
            onDismissRequest = { showGenderDialog.value =false }
            , confirmButton = {
                Button(
                    onClick = {
                        showGenderDialog.value = false
                    }
                ) {
                    Text("Cancel")
                }
            },
            title = {
                Text(text = "Select Gender", fontWeight = FontWeight.Bold , fontSize = 30.sp)
            },
            text = {
                Column {
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp),
                        modifier = Modifier.clickable {
                            selectedGender.value = "Male"
                            showGenderDialog.value = false
                        }
                    ){
                        Icon(imageVector = Icons.Rounded.PlayArrow, contentDescription = "")
                        Text(
                            text = "Male",
                            modifier = Modifier
                                .padding(vertical = 8.dp),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Medium,
                            color = colorResource(R.color.weight_bg)
                        )
                    }
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp),
                        modifier = Modifier.clickable {
                            selectedGender.value = "Female"
                            showGenderDialog.value = false
                        }
                    ){
                        Icon(imageVector = Icons.Rounded.PlayArrow, contentDescription = "")
                        Text(
                            text = "Female",
                            modifier = Modifier
                                .padding(vertical = 8.dp),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Medium,
                            color = colorResource(R.color.weight_bg)
                        )
                    }
                }
            }

        )
    }
    if (showBirthDateDialog.value) {
        val datePickerDialog = DatePickerDialog(
            context,
            { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                calendar.set(year, month, dayOfMonth)
                selectedBirthDate.value = calendar.time
                showBirthDateDialog.value = false
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        datePickerDialog.show()
        showBirthDateDialog.value = false
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.user_page_bg))
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, top = 26.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            IconButton(onClick = {
                if (navController.previousBackStackEntry != null) {
                    navController.popBackStack()
                }
            }) {
                Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription ="", tint = Color.Black)
            }
            Text(text = "Personal Information",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold ,
                fontFamily = FontFamily.Serif)
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 16.dp, horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "GENDER", fontSize = 26.sp, fontWeight = FontWeight.Medium , color = colorResource(R.color.weight_bg))
                IconButton(onClick = {
                    showGenderDialog.value = true
                }) {
                    Icon(imageVector = Icons.Rounded.KeyboardArrowRight,
                        contentDescription ="" ,
                        modifier = Modifier.size(30.dp) ,
                        tint = colorResource(R.color.black))
                }
            }
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "WEIGHT / HEIGHT", fontSize = 26.sp, fontWeight = FontWeight.Medium, color = colorResource(R.color.weight_bg))
                IconButton(onClick = {
                    //weight height screen
                    navController.navigate("HeightWeightScreen")
                }) {
                    Icon(imageVector = Icons.Rounded.KeyboardArrowRight,
                        contentDescription ="" ,
                        modifier = Modifier.size(30.dp) ,
                        tint = colorResource(R.color.black))
                }
            }
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "BIRTHDAY", fontSize = 26.sp, fontWeight = FontWeight.Medium , color = colorResource(R.color.weight_bg))
                IconButton(onClick = {
                    showBirthDateDialog.value = true
                }) {
                    Icon(imageVector = Icons.Rounded.KeyboardArrowRight,
                        contentDescription ="" ,
                        modifier = Modifier.size(30.dp) ,
                        tint = colorResource(R.color.black))
                }
            }
            Spacer(modifier = Modifier.height(60.dp))
            Image(painterResource(R.drawable.better_health),
                contentDescription ="logo",
                modifier = Modifier
                    .size(250.dp)
                    .alpha(0.62f)
            )
        }
    }
}

@Composable
fun HeightWeightScreen(navController: NavHostController) {
    val height = remember { mutableStateOf("") }
    val weight = remember { mutableStateOf("") }

    Column (
        modifier = Modifier.fillMaxSize().background(colorResource(R.color.user_page_bg))
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, top = 26.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            IconButton(onClick = {
                if (navController.previousBackStackEntry != null) {
                    navController.popBackStack()
                }
            }) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = "",
                    tint = Color.Black
                )
            }
            Text(
                text = "Height and Weight",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                OutlinedTextField(
                    value = height.value,
                    onValueChange = {
                        if (it.all { char -> char.isDigit() || char == '.' }) {
                            height.value = it
                        }},
                    label = {
                        Text(text = "Height" , fontSize = 20.sp, fontWeight = FontWeight.Medium , fontFamily = FontFamily.Serif)
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    placeholder = { Text(text = "...") }
                )
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                ,
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                OutlinedTextField(
                    value = weight.value,
                    onValueChange = {
                        if (it.all { char -> char.isDigit() || char == '.' }) {
                            weight.value = it
                        }
                    },
                    label = {
                        Text(text = "Weight" , fontSize = 20.sp, fontWeight = FontWeight.Medium , fontFamily = FontFamily.Serif)
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    placeholder = { Text(text = "...") }
                )
            }

            // Button to Navigate Back
            Button(
                onClick = {
                    // Here, you can store the height and weight values and navigate back
                    // db operation
                    if (navController.previousBackStackEntry != null) {
                        navController.popBackStack()
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.weight_bg),
                    contentColor = colorResource(R.color.white)
                ),
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(text = "Save")
            }
        }
    }

}
