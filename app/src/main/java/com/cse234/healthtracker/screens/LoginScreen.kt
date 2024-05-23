package com.cse234.healthtracker.screens


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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text




import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.cse234.healthtracker.R
import com.cse234.healthtracker.viewmodels.LoginViewModel


@Composable
fun LoginScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = colorResource(R.color.login_bg)
            )
            .padding(horizontal = 40.dp)
        ,
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "HEALTH TRACKER",
            fontWeight = FontWeight.W900,
            fontSize = 30.sp,
            color = colorResource(R.color.fade_red),
            modifier = Modifier.shadow(
                elevation = 30.dp,
                spotColor = colorResource(R.color.teal_700)
            )
        )
        Image(painter = painterResource(R.drawable.better_health), contentDescription ="logo" )

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = { navController.navigate("LoginProcedure") },
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .shadow(
                    elevation = 30.dp,
                    spotColor = colorResource(R.color.red)
                )
            ,
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.black)
            )
        ) {
            Text(
                text = "Log In",
                color = colorResource(R.color.fade_red),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
            )
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                painter = painterResource(R.drawable.key2),
                contentDescription ="key_logo",
                modifier = Modifier.size(30.dp))
        }
        Spacer(modifier = Modifier.height(20.dp))
        HorizontalDivider(color = colorResource(R.color.black), thickness = 2.dp)
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { navController.navigate("RegisterProcedure") },
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .shadow(
                    elevation = 30.dp,
                    spotColor = colorResource(R.color.red)
                ),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.black)
            )
        ) {
            Text(
                text = "Register",
                color = colorResource(R.color.fade_red),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
            )
        }
        Spacer(modifier = Modifier.height(200.dp))


    }
}


@Composable
fun LoginProcedure(navController: NavHostController) {

    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val context = LocalContext.current
    val loginViewModel = remember { LoginViewModel(context, navController) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .background(
                color = colorResource(R.color.login_bg)
            ),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row (
            modifier = Modifier
                .fillMaxWidth()
        ){
            IconButton(
                modifier = Modifier.padding(start = 16.dp, top = 22.dp),
                onClick = {
                    if (navController.previousBackStackEntry != null) {
                        navController.popBackStack()
                    }
                }
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription ="go back" )
            }
        }

        Box (
            modifier = Modifier
                .padding(top = 48.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Image(
                painter = painterResource(R.drawable.key),
                contentDescription ="key logo",
                modifier = Modifier.size(150.dp)
            )
        }
        Spacer(modifier = Modifier.height(14.dp))
        Text(
            text = "Login your credentials",
            fontWeight = FontWeight.Thin,
            fontFamily = FontFamily.Serif,
            fontSize = 30.sp,
            color = colorResource(R.color.black),
            softWrap = true
        )
        Spacer(modifier = Modifier.height(70.dp))
        OutlinedTextField(
            value =emailState.value,
            onValueChange = { emailState.value = it},
            label = {
                Text(
                    text = "Email...",
                    color = colorResource(R.color.white)
                )
            }
        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = passwordState.value,
            onValueChange = {passwordState.value = it},
            label = {
                Text(
                    text = "Password...",
                    color = colorResource(R.color.white)
                )
            })
        Spacer(modifier = Modifier.height(48.dp))
        Button(
            onClick = {
                loginViewModel.signIn(emailState.value, passwordState.value)
                //navigate if successful
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.black)
            ),
            enabled = emailState.value.isNotBlank() && passwordState.value.isNotBlank()
        ) {
            Text(
                text = "Login",
                color = colorResource(R.color.green),
                fontWeight = FontWeight.Thin,
                fontFamily = FontFamily.Serif,
                fontSize = 30.sp

            )
        }

    }
}


@Composable
fun RegisterProcedure(navController: NavHostController) {

    val firstNameState = remember { mutableStateOf("") }
    val lastNameState = remember { mutableStateOf("") }
    val ageState = remember { mutableStateOf("") }
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val isEnabled = firstNameState.value.isNotBlank() && lastNameState.value.isNotBlank() && emailState.value.isNotBlank() && passwordState.value.isNotBlank()
    val context = LocalContext.current
    val loginViewModel = remember { LoginViewModel(context, navController) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .background(
                color = colorResource(R.color.login_bg)
            ),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row (
            modifier = Modifier
                .fillMaxWidth()
        ){
            IconButton(
                modifier = Modifier.padding(start = 16.dp, top = 22.dp),
                onClick = {
                    if (navController.previousBackStackEntry != null) {
                        navController.popBackStack()
                    }
                }
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription ="go back" )
            }
        }

        Box (
            modifier = Modifier
                .padding(top = 10.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Image(
                painter = painterResource(R.drawable.document),
                contentDescription ="key logo",
                modifier = Modifier.size(150.dp)
            )
        }
        Spacer(modifier = Modifier.height(14.dp))
        Text(
            text = "Register",
            fontWeight = FontWeight.Thin,
            fontFamily = FontFamily.Serif,
            fontSize = 30.sp,
            color = colorResource(R.color.black),
            softWrap = true
        )
        Spacer(modifier = Modifier.height(30.dp))
        OutlinedTextField(
            value =firstNameState.value ,
            onValueChange = {firstNameState.value = it},
            label = {
                Text(
                    text = "First name...",
                    color = colorResource(R.color.white)
                )
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value =lastNameState.value ,
            onValueChange = {lastNameState.value = it},
            label = {
                Text(
                    text = "Last name...",
                    color = colorResource(R.color.white)
                )
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value =emailState.value ,
            onValueChange = {emailState.value = it},
            label = {
                Text(
                    text = "Email...",
                    color = colorResource(R.color.white)
                )
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = passwordState.value,
            onValueChange = {passwordState.value = it},
            label = {
                Text(
                    text = "Password...",
                    color = colorResource(R.color.white)
                )
            })
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {
                loginViewModel.signUp(emailState.value , passwordState.value, firstNameState.value, lastNameState.value)
                //navigate if successful
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.black)
            ),
            enabled = isEnabled
        ) {
            Text(
                text = "Register me",
                color = colorResource(R.color.green),
                fontWeight = FontWeight.Thin,
                fontFamily = FontFamily.Serif,
                fontSize = 28.sp

            )
        }

    }

}