package com.example.navigation.navigate

sealed class AppScreens(val route: String, val title: String) {
    data object FirstScreen: AppScreens("first_screen", "First Screen")
    data object SecondScreen: AppScreens("second_screen", "Second Screen")
}