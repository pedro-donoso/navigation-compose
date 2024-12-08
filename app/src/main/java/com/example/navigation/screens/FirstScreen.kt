package com.example.navigation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navigation.navigate.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(navController: NavController) {
    TopAppBar(
        title = { Text(text = "First Screen") }
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        // Texto centrado en la parte superior
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Bienvenidos", style = MaterialTheme.typography.titleLarge)
        }

        // Botón al borde inferior sin bordes redondeados
        Button(
            onClick = {
                navController.navigate(route = AppScreens.SecondScreen.route + "/-> Este es un parámetro")
            },
            modifier = Modifier
                .align(Alignment.BottomStart)
                .width(140.dp)
                .height(60.dp)
                .padding(bottom = 16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp),
            shape = RectangleShape // Sin bordes redondeados
        ) {
            Text(text = "Navegar", style = MaterialTheme.typography.headlineSmall)
        }
    }
}





