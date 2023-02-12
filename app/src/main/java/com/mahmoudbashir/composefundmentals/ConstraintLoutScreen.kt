package com.mahmoudbashir.composefundmentals

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

@Composable
fun ConstraintL(){
    val constraints = ConstraintSet{
        val greenBox = createRefFor("green")
        val redBox = createRefFor("red")
        constrain(greenBox){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        constrain(redBox){
            top.linkTo(parent.top)
            start.linkTo(greenBox.end)
            end.linkTo(parent.end)
          //bottom.linkTo(parent.bottom)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        createHorizontalChain(greenBox,redBox, chainStyle = ChainStyle.Packed)
    }
    ConstraintLayout(
        constraints, modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .layoutId("green").
                border(2.dp,Color.Green, RoundedCornerShape(13.dp)),
            contentAlignment = Alignment.Center
        ){
                Text(text = "Card 1",
                    style = TextStyle(
                        color = Color.Black,
                    ),
                    textAlign = TextAlign.Center
                )

        }

        Box(modifier = Modifier
            .background(Color.Red)
            .layoutId("red")
        ) {

        }
    }
}