package com.example.navigation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FirstScreen() {
    Scaffold {
        BodyContent()
    }
}

@Composable
fun BodyContent() {
    Column() {
        Text(text = "Hola Navegación")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Navega")

        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FirstScreen()
}
