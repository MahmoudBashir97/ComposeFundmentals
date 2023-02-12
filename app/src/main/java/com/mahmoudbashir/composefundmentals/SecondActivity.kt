package com.mahmoudbashir.composefundmentals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mahmoudbashir.composefundmentals.ui.theme.ComposeFundmentalsTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            ComposeFundmentalsTheme {
                Surface(
                    modifier =Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold {
                        Greeting("Mahmoud")
                    }
                }

            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun Greeting(name: String="mm") {
        Text(text = "Hello $name!")
    }
}

