package com.example.navigation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigation.navigate.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(navController: NavController) {
    TopAppBar(
        title = { Text(text = "First Screen") },
        navigationIcon = {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier.clickable {
                    navController.popBackStack()
                })
        }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Hola navegación")
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                navController.navigate(route = AppScreens.SecondScreen.route + "/Este es un parámetro")
            },
            modifier = Modifier
                .width(200.dp)
                .height(50.dp)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(text = "Navega")
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.FirstScreen.route){
        composable(route = AppScreens.FirstScreen.route) {
            FirstScreen(navController)
        }
        composable(route = AppScreens.SecondScreen.route + "/{text}",
            arguments = listOf(navArgument(name = "text") {
                type = NavType.StringType
            })) {
            SecondScreen(navController, it.arguments?.getString("text"))
        }
    }
}