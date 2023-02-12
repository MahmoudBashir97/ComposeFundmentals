package com.mahmoudbashir.composefundmentals

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import android.content.Intent
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(navHostController: NavHostController,onNextClick:()->Unit){
    val context = LocalContext.current
    NavHost(navController = navHostController, startDestination = "home"){
        composable(route="home"){
            (context as MainActivity).window.statusBarColor = context.resources.getColor(R.color.black)
            HomeScreen{
                onNextClick()
            }
        }
        composable(route="chat"){
            (context as MainActivity).window.statusBarColor = context.resources.getColor(R.color.purple_200)
            ChatScreen()
        }
        composable(route="settings"){
            (context as MainActivity).window.statusBarColor = context.resources.getColor(R.color.teal_200)
            SettingsScreen()
        }
    }
}

@Composable
fun MainHost(navHostController: NavHostController){
    val context = LocalContext.current
    NavHost(navController = navHostController, startDestination = "main"){
        composable(route = "main"){
            ViewBottomNav{
                navHostController.clearBackStack("main")
               // navHostController.navigate("constraint")
//                val intent = Intent(context,SecondActivity::class.java)
//                    .also {
//                        it.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
//                    }
//                context.startActivity(intent)
                showAlertDialog(context = context)
            }
        }
        composable(route="constraint"){
            ConstraintL()
        }
    }
}

fun showAlertDialog(context: Context){
    val dialog: AlertDialog? = AlertDialog.Builder(context)
        .setTitle("Alert")
        .setMessage("Alertmmmmmmm")
        .setPositiveButton("Ok") { d, p->
            d.dismiss()
        }
        .setNegativeButton("Cancel"){d,p->
            d.dismiss()
        }
        .setCancelable(true)
        .create()

    dialog?.show()

}