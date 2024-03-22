package com.zenith.animation_assignment.screen

import android.annotation.SuppressLint
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import androidx.compose.ui.unit.dp

@SuppressLint("RememberReturnType")
@Composable
fun Screen2(navController: NavController) {
    var isExpanded by remember { mutableStateOf(false) }

    val animatableSize = remember { Animatable(0f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       Button(onClick={navController.navigate("main")}){
           Text("Go Back")
       }
        Button(
            onClick = {
                isExpanded = !isExpanded
            },
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            if (isExpanded) {
                Text(text = "Collapse")
            } else {
                Text(text = "Expand")
            }
        }

        Box(
            modifier = Modifier
                .size(animatableSize.value.dp)
                .background(Color.Green)
        )

        LaunchedEffect(isExpanded) {
            val targetValue = if (isExpanded) 290f else 0f
            animatableSize.animateTo(
                targetValue,
                animationSpec = tween(durationMillis = 1000)
            )
        }
    }
}
