package com.mahmoudbashir.composefundmentals

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun ViewBottomNav(onNextClick:()->Unit){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(items = listOf(
                BottomNavItem(
                    name = "Home",
                    route = "home",
                    icon = Icons.Default.Home,
                ),
                BottomNavItem(
                    name = "Chat",
                    route = "chat",
                    icon = Icons.Default.Notifications,
                    badgeCount = 220
                ),
                BottomNavItem(
                    name = "Settings",
                    route = "settings",
                    icon = Icons.Default.Settings,
                    badgeCount = 500
                )

            ),
                navController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                })
        }
    ) {
        Navigation(navHostController = navController,onNextClick)
    }
}


@Composable
fun BottomNavigationBar(
    items:List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier=Modifier,
    onItemClick:(BottomNavItem)->Unit
){
    val backStackEntry = navController.currentBackStackEntryAsState()

    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.Gray,
        elevation = 10.dp,
    ) {
        items.forEach {item->
            var countDown by remember {
                mutableStateOf(item.badgeCount)
            }
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = {
                countDown = 0
                onItemClick(item)
                },
                selectedContentColor = Color.Yellow,
                unselectedContentColor = Color.White,
                icon = {
                Column(horizontalAlignment = CenterHorizontally) {
                    if (countDown > 0){
                        BadgedBox(badge = { Badge { Text(item.badgeCount.toString()) } }) {
                            Icon(
                                item.icon,
                                contentDescription = item.name
                            )
                        }
                    }else{
                        Icon(
                            item.icon,
                            contentDescription = item.name
                        )
                    }
                    if (selected){
                        Text(text = item.name,
                        textAlign = TextAlign.Center,
                        fontSize = 10.sp
                        )
                    }
                }
            })
        }
    }
}

@Composable
fun HomeScreen(onNextClick:()->Unit){
    var textVisibility by remember {
        mutableStateOf(true)
    }
    val density = LocalDensity.current
    Box(modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center){
        Column(
           modifier = Modifier.fillMaxSize() ,
        ) {
            AnimatedVisibility(visible = textVisibility,
                enter = slideInVertically {
                    // Slide in from 40 dp from the top.
                    with(density) { -40.dp.roundToPx() }
                } + expandVertically(
                    // Expand from the top.
                    expandFrom = Alignment.Top
                ) + fadeIn(
                    // Fade in with the initial alpha of 0.3f.
                    initialAlpha = 0.3f
                ),
                exit = slideOutVertically() + shrinkVertically() + fadeOut()
            ) {
                Text(text = "Home Screen",Modifier.fillMaxWidth().height(200.dp))
            }

            Button(onClick = {
                textVisibility = !textVisibility
                //onNextClick()
            }) {
                Text(text = "Next", fontSize = 18.sp)
            }
        }

    }
}


@Composable
fun ChatScreen(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(text = "Chat Screen")
    }
}


@Composable
fun SettingsScreen(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(text = "Settings Screen")
    }
}

data class BottomNavItem(
    val name:String,
    val route:String,
    val icon:ImageVector,
    val badgeCount:Int=0
)