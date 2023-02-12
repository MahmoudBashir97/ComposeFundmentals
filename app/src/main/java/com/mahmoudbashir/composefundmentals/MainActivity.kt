package com.mahmoudbashir.composefundmentals

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mahmoudbashir.composefundmentals.ui.theme.ComposeFundmentalsTheme


@Composable
fun Home(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        viewMessagesList()
    }

}

@Composable
fun Profile(navController: NavController) { /* code */
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var vis by remember {
                mutableStateOf(false)
            }
            val navController = rememberNavController()
//            NavHost(navController = navController, startDestination = "home") {
//                composable("profile") { Profile(navController) }
//                composable("home") { Home(navController) }
//            }
            ComposeFundmentalsTheme {
                BottomSheetCompose()
              // MainHost(navHostController = navController)
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    Scaffold {
//                       // ConstraintL()
//
//                       // ProgBarCompose()
//
//
////                        FloatingActionButton(
////                            modifier = Modifier
////                                .width(30.dp)
////                                .height(30.dp),
////                            backgroundColor = Color.Blue,
////                            contentColor = Color.White,
////                            onClick = {
////                                vis = true
////                                navController.navigate("home") {
////                                    popUpTo("home")
////                                }
////                                Toast.makeText(this, "Floating clicked!", Toast.LENGTH_LONG).show()
////                            }) {
////                            Spacer(
////                                modifier = Modifier
////                                    .width(10.dp)
////                                    .height(10.dp)
////                            )
////                            //Text(text = "Click"
////                            if (vis) Icon(Icons.Filled.Add, "")
////                            else Icon(Icons.Filled.Create, "")
////                        }
//
//                    }
//
//
//                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeFundmentalsTheme {
        Greeting("Android")
    }
}

@Composable
fun viewMessagesList() {
    val messagesList = listOf(
        Message("Mahmoud", "Hi memo"),
        Message("Mahmoud", "Hi memo"),
        Message("Mahmoud", "Hi memo"),
        Message("Mahmoud", "Hi memo"),
        Message("Mahmoud", "Hi memo"),
        Message("Mahmoud", "Hi memo"),
        Message("Mahmoud", "Hi memo"),
        Message("Mahmoud", "Hi memo"),
        Message("Mahmoud", "Hi memo"),
        Message("Mahmoud", "Hi memo"),
        Message("Mahmoud", "Hi memo"),
        Message("Mahmoud", "Hi memo"),
        Message("Mahmoud", "Hi memo"),
        Message("Mahmoud", "Hi memo"),
        Message("Mahmoud", "Hi memo"),
        Message("Mahmoud", "Hi memo"),
        Message("Mahmoud", "Hi memo"),
        Message("Mahmoud", "Hi memo"),
        Message("Mahmoud", "Hi memo"),
        Message("Mahmoud", "Hi memo"),
        Message("Mahmoud", "Hi memo"),
        Message("Mahmoud", "Hi memo"),
        Message("Mahmoud", "Hi memo")
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        items(messagesList) { message ->
            MessageRow(message)
        }
    }
}

@Composable
fun MessageRow(message: Message) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(0.5.dp, Color.Gray, RectangleShape)
            .padding(8.dp)
    ) {
        Text(text = message.name)
        Text(text = message.message)
    }
}


data class Message(
    val name: String,
    val message: String
)

@Preview(showBackground = true)
@Composable
fun MyText() {
    Text(
        text = "MMMMM",
        style = TextStyle(
            color = Color.Red,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Default
        ),
        maxLines = 2,

        )
}

@Preview(showBackground = true)
@Composable
fun MyButton() {
    var btnIsEnabled by remember {
        mutableStateOf(true)
    }
    Button(
        onClick = { btnIsEnabled = !btnIsEnabled },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Green,
            contentColor = Color.White,
            disabledBackgroundColor = Color.Gray,
            disabledContentColor = Color.Black
        ),
        enabled = btnIsEnabled
    ) {
        Text(text = if (btnIsEnabled) "Click Me" else "I'm disabled")
    }
}

@Preview(showBackground = true)
@Composable
fun MyTextField() {
    var emailAddress by remember { mutableStateOf("") }
    TextField(
        value = emailAddress,
        onValueChange = {
            emailAddress = it
        },
        label = {
            Text(text = "Email Address")
        },
    )
}

@Preview(showBackground = true)
@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.compose_logo),
        contentDescription = "Logo"
    )
}

@Preview(showBackground = true)
@Composable
fun MyLayout() {
    Column {
        MyText()
        MyButton()
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "My Logo")
            MyImage()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyBoxLayout(){
    Box(modifier = Modifier
        .size(120.dp)
        .background(Color.Black)
        .padding(10.dp)
        .clip(RoundedCornerShape(size = 10.dp))
        .background(Color.LightGray)
    ){
        Text(text = "Android",Modifier.align(Alignment.TopStart), color = Color.Blue)
        Text(text = "Box",Modifier.align(Alignment.Center), color = Color.Blue)
        Text(text = "Google",Modifier.align(Alignment.BottomEnd), color = Color.Blue)
    }
}