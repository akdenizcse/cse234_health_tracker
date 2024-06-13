package com.cse234.healthtracker.screens



import android.util.Log
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.sharp.AccountCircle
import androidx.compose.material.icons.sharp.ExitToApp
import androidx.compose.material.icons.twotone.Face
import androidx.compose.material.icons.twotone.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.cse234.healthtracker.R
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore


@Composable
fun UserProfileScreen(navController : NavHostController) {

    val auth = FirebaseAuth.getInstance()
    val db = Firebase.firestore
    val userId = auth.currentUser?.uid
    val firstName = remember { mutableStateOf("User") }
    val lastName = remember { mutableStateOf("Name") }

    if (userId != null) {
        db.collection("users")
            .document(userId)
            .get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    firstName.value = document.getString("firstName").toString()
                    lastName.value = document.getString("lastName").toString()

                    Log.d("SIGNIN", "User Info: $firstName $lastName")
                } else {
                    Log.d("SIGNIN", "No such document")
                }

            }
            .addOnFailureListener { exception ->
                Log.d("SIGNIN", "get failed with ", exception)
            }
    }

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
                            onClick = {
                                auth.signOut()
                                navController.navigate("LoginScreen")
                            },
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
                    Text(text = "${firstName.value} ${lastName.value}", fontSize = 32.sp, fontFamily = FontFamily.Serif)
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
                    IconButton(onClick = {
                        navController.navigate("PersonalInfoScreen")
                    }) {
                        Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "")
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
                        Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "")
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
                    IconButton(onClick = {
                        navController.navigate("AboutScreen")
                    }) {
                        Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "")
                    }
                }

            }
        }

    }


}