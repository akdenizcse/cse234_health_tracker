import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.sharp.List
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    Spacer(modifier = Modifier.height(30.dp))
    CircularProgressBar(
        timePercantage = 15/45f,
        timeNumber = 45,
        stepsPercantage =4000/6000f ,
        stepsNumber = 6000,
        caloriesPercantage =120/240f ,
        caloriesNumber = 240
    )
    Spacer(modifier = Modifier.height(30.dp))
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Card ( // PAST ACTIVITIES
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
            Column (
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(text = "PAST ACTIVITIES")
            }
        }
        Card ( // WEIGHT, HEIGHT
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
            Column (
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(text = "WEIGHT")
                Divider(modifier = Modifier.padding(horizontal = 28.dp, vertical= 5.dp))
                Text(text = "HEIGHT")
            }
        }

    }
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Card( // SLEEP
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
            Column (
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(text = "SLEEP")
            }
        }
        Card( // GOALS
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
            Column (
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(text = "GOALS")
            }
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
        BottomNavItem("Activities", "ActivitiesScreen", Icons.Sharp.List),
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
@Composable
fun CircularProgressBar(
    timePercantage : Float,
    timeNumber : Int,
    stepsPercantage : Float,
    stepsNumber : Int,
    caloriesPercantage : Float,
    caloriesNumber : Int,
    strokeWidth : Dp =8.dp,
    animDuration: Int=2500,
    animDelay: Int=0
){
    var animationPlayed by remember {
        mutableStateOf(false)
    }
    val stepsCurrentPercantage = animateFloatAsState(
        targetValue = if (animationPlayed) stepsPercantage else 0f,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = animDelay
        )
    )
    val caloriesCurrentPercantage = animateFloatAsState(
        targetValue = if (animationPlayed) caloriesPercantage else 0f,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = animDelay
        )
    )
    val timeCurretPercantage = animateFloatAsState(
        targetValue = if (animationPlayed) timePercantage else 0f,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = animDelay
        )
    )
    val color1 = colorResource(id = R.color.transblue)
    val color2 = colorResource(id = R.color.transgreen)
    val color3 = colorResource(id = R.color.transyellow)
    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .size(250.dp, 230.dp)
            .padding(horizontal = 20.dp)
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

        ){
        Row (modifier = Modifier.fillMaxSize()){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.padding(vertical =40.dp, horizontal = 30.dp)

            ){
                androidx.compose.foundation.Canvas(modifier = Modifier.size(150.dp)) {
                    drawArc(
                        color= color1,
                        -90f,
                        360*stepsCurrentPercantage.value,
                        useCenter = false,
                        style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
                    )
                }
                androidx.compose.foundation.Canvas(modifier = Modifier.size(130.dp)) {
                    drawArc(
                        color= color2,
                        -90f,
                        360*caloriesCurrentPercantage.value,
                        useCenter = false,
                        style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
                    )
                }
                androidx.compose.foundation.Canvas(modifier = Modifier.size(110.dp)) {
                    drawArc(
                        color= color3,
                        -90f,
                        360*timeCurretPercantage.value,
                        useCenter = false,
                        style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
                    )
                }
            }

            Column (
            ){
                Spacer(modifier = Modifier.height(40.dp))
                Row(){
                    Icon(Icons.Filled.Star, contentDescription ="" , tint = color1)
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Steps",
                        color=color1,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Text(
                    text = (stepsCurrentPercantage.value*stepsNumber).toInt().toString()+"/"+stepsNumber,
                    color = color1,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(20.dp))

                Row() {
                    Icon(Icons.Filled.Star, contentDescription ="" , tint = color2)
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Calories",
                        color=color2,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Text(
                    text =(caloriesCurrentPercantage.value*caloriesNumber).toInt().toString()+"/"+caloriesNumber,
                    color=color2,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row {
                    Icon(Icons.Filled.Star, contentDescription ="" , tint = color3)
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Training Time",
                        color=color3,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Text(
                    text =(timeCurretPercantage.value*timeNumber).toInt().toString()+"/"+timeNumber,
                    color=color3,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

            }
        }
    }
}