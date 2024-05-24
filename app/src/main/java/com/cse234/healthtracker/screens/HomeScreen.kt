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
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.cse234.healthtracker.R
import com.cse234.healthtracker.data.BottomNavItem


@Composable
fun HomeScreen(navController: NavHostController) {

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController, onItemClick = { navController.navigate(it.route)})
        }
    ) {innerPadding -> // innerPadding is the padding that is applied by the Scaffold
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(colorResource(id = R.color.home_screen_bg))
        ){
            HomeScreenTopCard()
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
            containerColor = colorResource(id = R.color.login_bg),
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
                .padding(horizontal = 16.dp, vertical = 2.dp)
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
                containerColor = colorResource(id = R.color.login_bg),
                contentColor = Color.Black
            ),
            elevation = CardDefaults.cardElevation(16.dp)
        ){

        }
        Card (
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 2.dp)
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
                containerColor = colorResource(id = R.color.login_bg),
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
                containerColor = colorResource(id = R.color.login_bg),
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
                containerColor = colorResource(id = R.color.login_bg),
                contentColor = Color.Black
            ),
            elevation = CardDefaults.cardElevation(16.dp)
        ) {

        }
    }

}

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {

    val backStackEntry = navController.currentBackStackEntryAsState()
    val items : List<BottomNavItem> = listOf(
        BottomNavItem("Home", "HomeScreen", Icons.Filled.Home),
        BottomNavItem("Activities", "ActivitiesScreen", Icons.Filled.List),
        BottomNavItem("User", "UserProfileScreen", Icons.Filled.Person)
    )
    NavigationBar (
        modifier = modifier,
        containerColor = colorResource(R.color.login_bg),
        tonalElevation = 10.dp
    ){
        items.forEach {
            val selected = backStackEntry.value?.destination?.route == it.route
            NavigationBarItem(
                selected = selected,
                onClick = { onItemClick(it) },
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                        Icon(imageVector = it.icon, contentDescription = it.name)
                        if (selected){
                            Text(text = it.name)
                        }
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = colorResource(R.color.black),
                    unselectedIconColor = colorResource(R.color.black),
                    indicatorColor = colorResource(R.color.user_page_bg),
                )
            )
        }

    }
}