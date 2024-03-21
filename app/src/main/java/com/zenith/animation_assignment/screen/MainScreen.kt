package com.zenith.animation_assignment.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Check out all these animation:")
        Spacer(modifier = Modifier.height(16.dp))
        Text("Check out the Animated Content")
        Button(onClick = {
                navController.navigate("screen1")
        }) {
            Text("Go to Animation 1")
        }
        Text("Check out the Value based Animation")
        Button(onClick = {
            navController.navigate("screen1")
        }) {
            Text("Go to Animation 2")
        }
        Text("Check out the Value based Animation : 2")
        Button(onClick = {
            navController.navigate("screen1")
        }) {
            Text("Go to Animation 3")
        }
        Text("Check out the Gesture based Animation")
        Button(onClick = {
            navController.navigate("screen1")
        }) {
            Text("Go to Animation 4")
        }
    }
}
