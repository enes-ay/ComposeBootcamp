package com.example.odev3

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavArgs
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.odev3.model.Country
import com.google.gson.Gson

@Composable
fun Screens(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home"){
        composable("home"){
            HomePage(navController = navController)
        }
        composable("countryDetail/{countryCode}/{countryName}",
            arguments = listOf(navArgument("countryName") { type = NavType.StringType },
                navArgument("countryCode"){type = NavType.StringType}
            )
        ) { backStackEntry ->
            val countryName = backStackEntry.arguments?.getString("countryName")
            val countryCode = backStackEntry.arguments?.getString("countryCode")

            Detail(country_name = countryName, country_code = countryCode,navController)
        }

    }
}