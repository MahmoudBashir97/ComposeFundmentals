package com.mahmoudbashir.composefundmentals

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.mahmoudbashir.composefundmentals.ui.theme.ComposeFundmentalsTheme

@Composable
fun MainScreen(navController: NavHostController){
    ComposeFundmentalsTheme {
        ConstraintL()
    }
}