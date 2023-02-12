package com.mahmoudbashir.composefundmentals

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProgBarCompose(){
    Box(modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center){
        CircularProBar(percentage = 0.8f, number = 100)
    }
}

@Composable
fun CircularProBar(percentage:Float,
                   number:Int,
                   fontSize:TextUnit=25.sp,
                   radius:Dp = 50.dp,
                   color: Color=Color.Green,
                   strokeWidth:Dp=8.dp,
                   animDuration:Int=1000,
                   animDelay:Int=0
){
    var animationPlayed by remember {
        mutableStateOf(false)
    }
    val currPercentage = animateFloatAsState(
        targetValue =if (animationPlayed) percentage else 0f,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = animDelay
        )
    )
    LaunchedEffect(key1 =true) {
        animationPlayed = true
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(radius*2f)
    ){
        Canvas(modifier = Modifier.size(radius*2f)){
            drawArc(
                color = color,
                -90f,
                360 * currPercentage.value,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(),
                    cap = StrokeCap.Round)
            )
        }
        Text(
            text = (currPercentage.value * number).toInt().toString(),
            style = TextStyle(
                color = Color.Black,
                fontSize = fontSize,
                fontWeight =  FontWeight.Bold
            )
        )
    }
}