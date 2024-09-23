package com.example.navigation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack

import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SecondScreen(navController: NavController, text: String?) {
    Scaffold(topBar = {
        TopAppBar(
            navigationIcon = {
                Icon(imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    })
            },
            title = { Text(text = "SecondScreen") }
        )
    }) {
        SecondBodyContent(navController, text)
    }
}

@Composable
fun SecondBodyContent(navController: NavController, text: String?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "He navegado")
        text?.let {
            Text(text = it)
        }
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text(text = "Volver atrás")
        }
    }
}


